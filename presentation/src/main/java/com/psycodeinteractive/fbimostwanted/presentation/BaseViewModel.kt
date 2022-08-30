package com.psycodeinteractive.fbimostwanted.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.psycodeinteractive.fbimostwanted.domain.execution.UseCaseExecutor
import com.psycodeinteractive.fbimostwanted.domain.execution.usecase.BaseUseCase
import com.psycodeinteractive.fbimostwanted.presentation.execution.UseCaseExecutorProvider
import com.psycodeinteractive.fbimostwanted.presentation.mapper.DefaultDomainToPresentationExceptionMapper
import com.psycodeinteractive.fbimostwanted.presentation.model.exception.PresentationException
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.channels.Channel.Factory.BUFFERED
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.receiveAsFlow
import javax.inject.Inject

abstract class BaseViewModel<BaseState : ViewState, BaseEvent : Event> : ViewModel() {

    @Inject
    private lateinit var useCaseExecutorProvider: UseCaseExecutorProvider

    @Inject
    private lateinit var defaultDomainToPresentationExceptionMapper: DefaultDomainToPresentationExceptionMapper

    private val useCaseExecutor: UseCaseExecutor = useCaseExecutorProvider(viewModelScope)

    private val _viewState by lazy { MutableStateFlow(StateWrapper(getInitialViewState())) }
    val viewState by lazy { _viewState.asStateFlow() }

    private val _eventChannel by lazy { Channel<BaseEvent>(BUFFERED) }
    val eventFlow by lazy { _eventChannel.receiveAsFlow() }

    abstract fun getInitialViewState(): BaseState

    protected fun updateViewState(mutation: BaseState.() -> Unit) {
        val currentState = _viewState.value.state
        mutation(currentState)
        val newStateWrapped = StateWrapper(currentState)
        _viewState.value = newStateWrapped
    }

    class StateWrapper<BaseState : ViewState>(val state: BaseState)

    protected fun BaseEvent.dispatch() = _eventChannel.trySend(this)

    protected fun <Output> BaseUseCase<Unit, Output>.execute(
        callback: (Output) -> Unit = {},
        onError: (PresentationException) -> Unit = {}
    ) = useCaseExecutor.execute(this, callback) { exception ->
        onError(defaultDomainToPresentationExceptionMapper.toPresentation(exception))
    }

    protected fun <Input, Output> BaseUseCase<Input, Output>.execute(
        value: Input,
        callback: (Output) -> Unit = {},
        onError: (PresentationException) -> Unit = {}
    ) = useCaseExecutor.execute(this, value, callback) { exception ->
        onError(defaultDomainToPresentationExceptionMapper.toPresentation(exception))
    }
}
