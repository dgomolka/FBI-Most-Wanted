package com.psycodeinteractive.fbimostwanted.presentation

import com.psycodeinteractive.fbimostwanted.domain.execution.UseCaseExecutor
import com.psycodeinteractive.fbimostwanted.domain.execution.usecase.BaseUseCase
import com.psycodeinteractive.fbimostwanted.domain.logger.Logger
import com.psycodeinteractive.fbimostwanted.presentation.execution.UseCaseExecutorProvider
import com.psycodeinteractive.fbimostwanted.presentation.mapper.DefaultDomainToPresentationExceptionMapper
import com.psycodeinteractive.fbimostwanted.presentation.model.exception.PresentationException
import com.psycodeinteractive.fbimostwanted.presentation.navigation.PresentationDestination
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.channels.Channel.Factory.BUFFERED
import kotlinx.coroutines.channels.onFailure
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.receiveAsFlow
import me.tatarka.inject.annotations.Inject

@Inject
abstract class BaseViewModel<BaseState : ViewState, BaseEvent : Event>(
    useCaseExecutorProvider: UseCaseExecutorProvider,
    private val defaultDomainToPresentationExceptionMapper: DefaultDomainToPresentationExceptionMapper,
    private val logger: Logger
) : SharedViewModel() {

    private val useCaseExecutor: UseCaseExecutor = useCaseExecutorProvider(viewModelScope)

    private val _viewState by lazy { MutableStateFlow(initialViewState.wrap()) }
    val viewState by lazy { _viewState.asStateFlow() }

    private val _eventChannel by lazy { Channel<BaseEvent>(BUFFERED) }
    val eventFlow by lazy { _eventChannel.receiveAsFlow() }

    private val _navigationCommands by lazy { Channel<PresentationDestination>(BUFFERED) }
    val navigationCommands by lazy { _navigationCommands.receiveAsFlow() }

    abstract val initialViewState: BaseState

    protected fun updateViewState(mutation: BaseState.() -> Unit) {
        val viewState = _viewState.value.state
        mutation(viewState)
        _viewState.value = viewState.wrap()
    }

    protected fun BaseEvent.dispatchEvent() {
        _eventChannel.trySend(this@dispatchEvent)
            .onFailure { exception ->
                exception?.let(logger::e)
            }
    }

    protected fun PresentationDestination.navigate() {
        _navigationCommands.trySend(this@navigate)
            .onFailure { exception ->
                exception?.let(logger::e)
            }
    }

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

    fun BaseState.wrap() = StateWrapper(this)

    class StateWrapper<BaseState : ViewState>(val state: BaseState)
}
