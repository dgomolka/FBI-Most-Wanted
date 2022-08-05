package com.psycodeinteractive.fbimostwanted.ui.widget

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.core.MutableTransitionState
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyItemScope
import androidx.compose.foundation.lazy.LazyListScope
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment.Companion.Center
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import com.psycodeinteractive.fbimostwanted.ui.R
import com.psycodeinteractive.fbimostwanted.ui.themeTypography

@Composable
fun <Model> FBIMostWantedLazyColumn(
    items: List<Model>,
    lazyListScope: LazyListScope.() -> Unit = {},
    lazyItemScope: @Composable LazyItemScope.(item: Model) -> Unit = {}
) {
    Box(
        modifier = Modifier.fillMaxSize()
    ) {
        EmptyListIndicator(items)
        List(items, lazyListScope, lazyItemScope)
    }
}

@Composable
private fun <Model> List(
    items: List<Model>,
    lazyListScope: LazyListScope.() -> Unit = {},
    lazyItemScope: @Composable LazyItemScope.(item: Model) -> Unit = {}
) {
    val visibleState = MutableTransitionState(initialState = items.isEmpty()).apply {
        targetState = items.isNotEmpty()
    }
    AnimatedVisibility(
        visibleState = visibleState
    ) {
        Box(
            modifier = Modifier.fillMaxSize()
        ) {
            LazyColumn {
                lazyListScope()
                items(items = items) { item: Model ->
                    lazyItemScope(item)
                }
            }
        }
    }
}

@Composable
private fun <Model> EmptyListIndicator(
    entries: List<Model>
) {
    val transitionState = MutableTransitionState(initialState = entries.isNotEmpty()).apply {
        targetState = entries.isEmpty()
    }

    AnimatedVisibility(
        visibleState = transitionState
    ) {
        Box(
            modifier = Modifier.fillMaxSize()
        ) {
            Text(
                modifier = Modifier.align(Center),
                text = stringResource(R.string.no_fetched_entries),
                textAlign = TextAlign.Center,
                style = themeTypography.h5
            )
        }
    }
}
