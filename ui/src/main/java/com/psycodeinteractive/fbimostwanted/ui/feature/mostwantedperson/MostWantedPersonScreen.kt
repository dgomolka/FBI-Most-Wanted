package com.psycodeinteractive.fbimostwanted.ui.feature.mostwantedperson

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Divider
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import com.psycodeinteractive.fbimostwanted.presentation.feature.mostwantedperson.MostWantedPersonViewModel
import com.psycodeinteractive.fbimostwanted.ui.Screen
import com.psycodeinteractive.fbimostwanted.ui.collectViewState
import com.psycodeinteractive.fbimostwanted.ui.feature.mostwantedlist.model.MostWantedListTopBarResourcesUiModel
import com.psycodeinteractive.fbimostwanted.ui.feature.mostwantedperson.mapper.MostWantedPersonPresentationToUiMapper
import com.psycodeinteractive.fbimostwanted.ui.feature.mostwantedperson.model.MostWantedPersonUiModel
import com.psycodeinteractive.fbimostwanted.ui.observeWithLifecycle
import com.psycodeinteractive.fbimostwanted.ui.widget.topbar.TopBar
import javax.inject.Inject

typealias MostWantedPersonScreen = @Composable (personId: String) -> Unit

@Inject
@Composable
fun MostWantedPersonScreen(
    provideMostWantedPersonViewModel: () -> MostWantedPersonViewModel,
    topBarResources: MostWantedListTopBarResourcesUiModel,
    mostWantedPersonPresentationToUiMapper: MostWantedPersonPresentationToUiMapper,
    personId: String
) {
    Screen(provideMostWantedPersonViewModel) { viewModel, lifecycleScope ->
        lifecycleScope.launchWhenCreated {
            viewModel.onViewCreated(personId)
        }

        HandleEvents(viewModel)

        val state by viewModel.collectViewState()
        val mostWantedPerson = state.mostWantedPerson?.let(mostWantedPersonPresentationToUiMapper::toUi)

        Column(
            modifier = Modifier.fillMaxSize()
        ) {
            // Toolbar - Number on the list
            TopBar(
                resources = topBarResources
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
    Box(
        modifier = Modifier.fillMaxSize()
    ) {
        if (mostWantedPerson != null) {
            // Picture | Name
            // Sex
            // Wanted for
            // From
            // Last seen - time and place
        } else {
        }
    }
}

private val topDividerColor = Color.LightGray.copy(0.35f)
