package com.psycodeinteractive.fbimostwanted.ui.widget

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.core.MutableTransitionState
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyItemScope
import androidx.compose.foundation.lazy.LazyListScope
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment.Companion.Center
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.psycodeinteractive.fbimostwanted.ui.R
import com.psycodeinteractive.fbimostwanted.ui.extension.value
import com.psycodeinteractive.fbimostwanted.ui.themeTypography
import com.psycodeinteractive.fbimostwanted.ui.widget.LazyItemsArrangement.Horizontal
import com.psycodeinteractive.fbimostwanted.ui.widget.LazyItemsArrangement.Vertical

private enum class LazyItemsArrangement {
    Vertical, Horizontal
}

@Composable
fun <Model> FBIMostWantedLazyRow(
    modifier: Modifier = Modifier,
    items: List<Model>,
    itemSpacing: Dp = defaultItemSpacing,
    contentPadding: PaddingValues = PaddingValues(0.dp),
    lazyListScope: LazyListScope.() -> Unit = {},
    lazyItemScope: @Composable LazyItemScope.(item: Model) -> Unit = {}
) {
    Box(
        modifier = modifier.fillMaxSize()
    ) {
        EmptyListIndicator(items)
        List(items, lazyListScope, lazyItemScope, itemSpacing, contentPadding, Horizontal)
    }
}

@Composable
fun <Model> FBIMostWantedLazyColumn(
    modifier: Modifier = Modifier,
    items: List<Model>,
    itemSpacing: Dp = defaultItemSpacing,
    contentPadding: PaddingValues = PaddingValues(0.dp),
    lazyListScope: LazyListScope.() -> Unit = {},
    lazyItemScope: @Composable LazyItemScope.(item: Model) -> Unit = {}
) {
    Box(
        modifier = modifier.fillMaxSize()
    ) {
        EmptyListIndicator(items)
        List(items, lazyListScope, lazyItemScope, itemSpacing, contentPadding, Vertical)
    }
}

@Composable
private fun <Model> List(
    items: List<Model>,
    lazyListScope: LazyListScope.() -> Unit = {},
    lazyItemScope: @Composable LazyItemScope.(item: Model) -> Unit = {},
    itemSpacing: Dp,
    contentPadding: PaddingValues,
    arrangement: LazyItemsArrangement
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
            val content: LazyListScope.() -> Unit = {
                lazyListScope()
                items(items = items) { item: Model ->
                    lazyItemScope(item)
                }
            }
            val spacing = Arrangement.spacedBy(itemSpacing)
            when (arrangement) {
                Vertical -> LazyColumn(
                    content = content,
                    contentPadding = contentPadding,
                    verticalArrangement = spacing
                )
                Horizontal -> LazyRow(
                    content = content,
                    contentPadding = contentPadding,
                    horizontalArrangement = spacing
                )
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
                text = R.string.no_items.value,
                textAlign = TextAlign.Center,
                style = themeTypography.h5
            )
        }
    }
}

private val defaultItemSpacing = 10.dp
