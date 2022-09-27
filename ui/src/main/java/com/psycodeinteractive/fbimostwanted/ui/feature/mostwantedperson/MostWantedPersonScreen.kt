package com.psycodeinteractive.fbimostwanted.ui.feature.mostwantedperson

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Divider
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.Lifecycle.State.CREATED
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import com.psycodeinteractive.fbimostwanted.presentation.feature.mostwantedperson.MostWantedPersonViewModel
import com.psycodeinteractive.fbimostwanted.ui.OnLifecycle
import com.psycodeinteractive.fbimostwanted.ui.R
import com.psycodeinteractive.fbimostwanted.ui.Screen
import com.psycodeinteractive.fbimostwanted.ui.collectViewState
import com.psycodeinteractive.fbimostwanted.ui.extension.string
import com.psycodeinteractive.fbimostwanted.ui.feature.mostwantedlist.model.MostWantedListTopBarResourcesUiModel
import com.psycodeinteractive.fbimostwanted.ui.feature.mostwantedperson.mapper.MostWantedPersonPresentationToUiMapper
import com.psycodeinteractive.fbimostwanted.ui.feature.mostwantedperson.model.ImageUiModel
import com.psycodeinteractive.fbimostwanted.ui.feature.mostwantedperson.model.MostWantedPersonUiModel
import com.psycodeinteractive.fbimostwanted.ui.observeWithLifecycle
import com.psycodeinteractive.fbimostwanted.ui.widget.image.HorizontalImageGallery
import com.psycodeinteractive.fbimostwanted.ui.widget.topbar.TopBar
import com.ramcosta.composedestinations.annotation.Destination
import kotlinx.coroutines.launch
import me.tatarka.inject.annotations.Inject

typealias MostWantedPersonScreen = @Composable (personId: String) -> Unit

@Destination
@Inject
@Composable
fun MostWantedPersonScreen(
    provideMostWantedPersonViewModel: () -> MostWantedPersonViewModel,
    mostWantedPersonPresentationToUiMapper: MostWantedPersonPresentationToUiMapper,
    personId: String
) {
    Screen(provideMostWantedPersonViewModel) { viewModel, _ ->
        OnLifecycle(minActiveState = CREATED) {
            viewModel.onViewCreated(personId)
        }

        HandleEvents(viewModel)

        val state by viewModel.collectViewState()
        val mostWantedPerson =
            state.mostWantedPerson?.let(mostWantedPersonPresentationToUiMapper::toUi)

        Column(
            modifier = Modifier.fillMaxSize()
        ) {
            // Toolbar - Number on the list
            TopBar(
                resources = MostWantedListTopBarResourcesUiModel
            )
            Divider(
                color = topDividerColor
            )
            MostWantedPersonDetails(mostWantedPerson)
        }
    }
}

@Composable
private fun HandleEvents(viewModel: MostWantedPersonViewModel) {
    viewModel.eventFlow.observeWithLifecycle { event ->
        when (event) {
            else -> {}
        }
    }
}

@Composable
private fun MostWantedPersonDetails(mostWantedPerson: MostWantedPersonUiModel?) {
    mostWantedPerson?.run {
        Column(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.spacedBy(columnItemsSpacing)
        ) {
            Text(text = title)
            if (images.isNotEmpty()) {
                HorizontalImageGallery(
                    modifier = Modifier.height(galleryHeight),
                    urls = images.map(ImageUiModel::large)
                )
            }
            Text(text = "${R.string.sex.string} ${sex.stringResource.string}")
            if (subjects.isNotEmpty()) {
                LazyRow {
                    items(subjects) { subject ->
                        Text(text = subject)
                    }
                }
            }
            Text(text = caution)
            Text(text = details)
        }
        // From
        // Last seen - time and place
    }
}

private val galleryHeight = 200.dp
private val columnItemsSpacing = 10.dp
private val topDividerColor = Color.LightGray.copy(0.35f)
