package com.psycodeinteractive.fbimostwanted.data.cache

import kotlinx.coroutines.async
import kotlinx.coroutines.awaitAll
import kotlinx.coroutines.flow.SharedFlow
import kotlinx.coroutines.flow.asFlow
import kotlinx.coroutines.runBlocking
import kotlin.test.BeforeTest
import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertFailsWith

class CacheTest {

    private lateinit var classUnderTest: Cache<String>

    @BeforeTest
    fun setup() {
        classUnderTest = Cache()
    }

    @Test
    fun `Given no state emitted when get flow then replays nothing`() = runBlocking {
        // When
        val actualStates: List<String> = (classUnderTest.flow as SharedFlow).replayCache

        // Then
        assertEquals(emptyList(), actualStates)
    }

    @Test
    fun `Given one state emitted when get flow then replays that state`() = runBlocking {
        // Given
        val givenStates = listOf("state1")
        val expectedStates = listOf(givenStates.last())
        givenStates.forEach { state -> classUnderTest.emit { state } }

        // When
        val actualStates: List<String> = (classUnderTest.flow as SharedFlow).replayCache

        // Then
        assertEquals(expectedStates, actualStates)
    }

    @Test
    fun `Given 3 states emitted when get flow then replays last state`() = runBlocking {
        // Given
        val givenStates = listOf("state1", "state2", "state3")
        val expectedStates = listOf(givenStates.last())
        givenStates.asFlow().collect { state -> classUnderTest.emit { state } }

        // When
        val actualStates: List<String> = (classUnderTest.flow as SharedFlow).replayCache

        // Then
        assertEquals(expectedStates, actualStates)
    }

    @Test
    fun `Given empty state and exception when emitIfEmpty then throws that exception`() {
        runBlocking {
            assertFailsWith(IllegalArgumentException::class) {
                // Given
                val givenIfEmptyMethod = { throw IllegalArgumentException() }

                // When
                classUnderTest.emitIfEmpty(givenIfEmptyMethod)
            }
        }
    }

    @Test
    fun `Given has state when clear then clears cached state and emits nothing`() = runBlocking {
        // Given
        val givenStates = listOf("state1")
        val expectedStates = emptyList<String>()
        classUnderTest.emit { givenStates.first() }

        // When
        classUnderTest.clear()
        val actualStates: List<String> = (classUnderTest.flow as SharedFlow).replayCache

        // Then
        assertEquals(expectedStates, actualStates)
    }

    @Test
    fun `Given empty state and 2 threads when emit and emitIfEmpty then emits only one initial emit result`() =
        runBlocking {
            // Given
            val initialState = "initial state"
            val givenInitialStateExecution = suspend { initialState }
            val emitIfEmptyState = "emit on empty state"
            val givenIfEmptyExecution = suspend { emitIfEmptyState }
            val expectedStates = listOf(initialState)

            val threads = listOf(
                async { classUnderTest.emit { givenInitialStateExecution() } },
                async { classUnderTest.emitIfEmpty(givenIfEmptyExecution) }
            )

            threads.awaitAll()

            // When
            val actualStates: List<String> = (classUnderTest.flow as SharedFlow).replayCache

            // Then
            assertEquals(expectedStates, actualStates)
        }

    @Test
    fun `Given empty state and 2 threads when emitIfEmpty then emits only first emitIfEmpty result`() =
        runBlocking {
            // Given
            val stateToEmitIfEmptyNumber1 = "state to emit if empty #1"
            val stateToEmitIfEmptyNumber2 = "state to emit if empty #2"
            val givenIfEmptyMethod1 = suspend { stateToEmitIfEmptyNumber1 }
            val givenIfEmptyMethod2 = suspend { stateToEmitIfEmptyNumber2 }
            val expectedStates = listOf(stateToEmitIfEmptyNumber1)

            val threads = listOf(
                async { classUnderTest.emitIfEmpty(givenIfEmptyMethod1) },
                async { classUnderTest.emitIfEmpty(givenIfEmptyMethod2) }
            )

            threads.awaitAll()

            // When
            val actualStates: List<String> = (classUnderTest.flow as SharedFlow).replayCache

            // Then
            assertEquals(expectedStates, actualStates)
        }
}
