package com.psycodeinteractive.fbimostwanted.ui.feature.mostwantedlist

import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.material.Divider
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.ripple.rememberRipple
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment.Companion.CenterVertically
import androidx.compose.ui.Alignment.Companion.End
import androidx.compose.ui.Alignment.Companion.Start
import androidx.compose.ui.Alignment.Companion.Top
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextOverflow.Companion.Ellipsis
import androidx.compose.ui.unit.dp
import com.psycodeinteractive.fbimostwanted.presentation.feature.mostwantedlist.MostWantedListViewModel
import com.psycodeinteractive.fbimostwanted.ui.feature.mostwantedlist.mapper.MostWantedListScreenPresentationDestinationToNavigationCallbackMapper
import com.psycodeinteractive.fbimostwanted.ui.feature.mostwantedlist.model.MostWantedListTopBarResourcesUiModel
import com.psycodeinteractive.fbimostwanted.ui.feature.mostwantedperson.mapper.MostWantedPersonPresentationToUiMapper
import com.psycodeinteractive.fbimostwanted.ui.feature.mostwantedperson.model.MostWantedPersonUiModel
import com.psycodeinteractive.fbimostwanted.ui.screen.Screen
import com.psycodeinteractive.fbimostwanted.ui.screen.ScreenNavigationContainer
import com.psycodeinteractive.fbimostwanted.ui.screen.collectViewState
import com.psycodeinteractive.fbimostwanted.ui.themeTypography
import com.psycodeinteractive.fbimostwanted.ui.widget.FBIMostWantedLazyColumn
import com.psycodeinteractive.fbimostwanted.ui.widget.topbar.TopBar
import com.ramcosta.composedestinations.annotation.Destination
import me.tatarka.inject.annotations.Inject

typealias MostWantedListScreen = @Composable (
    mostWantedListScreenCallbacks: MostWantedListScreenNavigationCallbacks
) -> Unit

@Destination
@Inject
@Composable
fun MostWantedListScreen(
    provideMostWantedListViewModel: () -> MostWantedListViewModel,
    mostWantedPersonPresentationToUiMapper: MostWantedPersonPresentationToUiMapper,
    presentationDestinationToNavigationCallbackMapper: MostWantedListScreenPresentationDestinationToNavigationCallbackMapper,
    screenNavigationCallbacks: MostWantedListScreenNavigationCallbacks
) {
    Screen(
        provideViewModel = provideMostWantedListViewModel,
        screenNavigationContainer = ScreenNavigationContainer(
            screenNavigationCallbacks,
            presentationDestinationToNavigationCallbackMapper
        )
    ) { viewModel, _ ->
        val state by viewModel.collectViewState()
        val mostWantedPersonList = state.mostWantedPersonList.map(
            mostWantedPersonPresentationToUiMapper::toUi
        )

        Column(
            modifier = Modifier.fillMaxSize()
        ) {
            TopBar(
                resources = MostWantedListTopBarResourcesUiModel
            )
            Divider(
                color = topDividerColor
            )
            FBIMostWantedLazyColumn(
                items = mostWantedPersonList
            ) { item ->
                MostWantedPersonListItem(
                    person = item,
                    onClick = viewModel::onMostWantedPersonClick
                )
            }
        }
    }
}

@Composable
private fun MostWantedPersonListItem(
    person: MostWantedPersonUiModel,
    onClick: (personId: String) -> Unit
) {
    val ripple = rememberRipple(
        color = MaterialTheme.colors.primary
    )
    val interactionSource = remember { MutableInteractionSource() }
    Box(
        modifier = Modifier.clickable(
            interactionSource = interactionSource,
            indication = ripple,
            onClick = { onClick(person.id) }
        )
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .wrapContentHeight()
                .padding(start = listItemPadding, end = listItemPadding, top = listItemPadding)
        ) {
            Row(
                modifier = Modifier.align(End)
            ) {
                Text(
                    modifier = Modifier.align(Top),
                    text = person.modified,
                    color = Color.LightGray,
                    style = themeTypography.caption
                )
            }
            Row(
                modifier = Modifier.align(Start)
            ) {
                Text(
                    modifier = Modifier
                        .fillMaxWidth(0.7f)
                        .align(CenterVertically),
                    maxLines = 2,
                    overflow = Ellipsis,
                    text = person.title,
                    style = themeTypography.body1
                )
            }
            Divider(
                modifier = Modifier.padding(top = listItemPadding),
                color = listItemDividerColor
            )
        }
    }
}

private val listItemPadding = 16.dp

private val listItemDividerColor = Color.LightGray.copy(0.3f)
private val topDividerColor = Color.LightGray.copy(0.35f)
