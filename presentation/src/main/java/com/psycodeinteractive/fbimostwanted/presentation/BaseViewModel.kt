package com.psycodeinteractive.fbimostwanted.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.psycodeinteractive.fbimostwanted.domain.base.exception.DomainException
import com.psycodeinteractive.fbimostwanted.domain.base.usecase.BaseUseCase
import com.psycodeinteractive.fbimostwanted.domain.execution.UseCaseExecutor
import com.psycodeinteractive.fbimostwanted.presentation.usecaseexecutor.UseCaseExecutorProvider
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.channels.Channel.Factory.BUFFERED
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.receiveAsFlow
import javax.inject.Inject

abstract class BaseViewModel<BaseState : ViewState, BaseEvent : Event> : ViewModel() {

    @Inject
    private lateinit var useCaseExecutorProvider: UseCaseExecutorProvider

    val state by lazy { MutableStateFlow(StateWrapper(getInitialState())) }

    private val _eventChannel by lazy { Channel<BaseEvent>(BUFFERED) }
    val eventFlow by lazy { _eventChannel.receiveAsFlow() }

    val StateFlow<StateWrapper<BaseState>>.current
        get() = this.value.state

    private val useCaseExecutor: UseCaseExecutor = useCaseExecutorProvider(viewModelScope)

    abstract fun getInitialState(): BaseState

    protected fun mutateViewState(mutation: BaseState.() -> Unit) {
        val currentState = state.value.state
        mutation(currentState)
        val newStateWrapped = StateWrapper(currentState)
        state.value = newStateWrapped
    }

    class StateWrapper<BaseState : ViewState>(val state: BaseState)

    protected fun BaseEvent.dispatch() = _eventChannel.trySend(this)

    protected fun <Output> BaseUseCase<Unit, Output>.execute(
        callback: (Output) -> Unit = {},
        onError: (DomainException) -> Unit = {}
    ) = useCaseExecutor.execute(this, callback, onError)

    protected fun <Input, Output> BaseUseCase<Input, Output>.execute(
        value: Input,
        callback: (Output) -> Unit = {},
        onError: (DomainException) -> Unit = {}
    ) = useCaseExecutor.execute(this, value, callback, onError)
}
