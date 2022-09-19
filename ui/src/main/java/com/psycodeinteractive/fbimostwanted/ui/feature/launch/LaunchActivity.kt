package com.psycodeinteractive.fbimostwanted.ui.feature.launch

import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.Composable
import com.psycodeinteractive.fbimostwanted.ui.feature.mostwantedlist.MostWantedListScreen
import com.psycodeinteractive.fbimostwanted.ui.feature.mostwantedperson.MostWantedPersonScreen
import com.psycodeinteractive.fbimostwanted.ui.feature.splash.SplashScreen



abstract class LaunchActivity : ComponentActivity() {

    fun setupScreens(
        splashScreen: SplashScreen,
        mostWantedListScreen: MostWantedListScreen,
        mostWantedPersonScreen: MostWantedPersonScreen
    ) {
        setContent {
//            Theme {
            splashScreen {

            }
        }
    }
}

@Composable
private fun Navigation() {
//    val navController = rememberNavController()
//
//    NavHost(
//        startDestination = initialRoute.asName,
//        navController = navController
//    ) {
//        destination(LaunchRoute.Splash) {
//            SplashScreen {
//                navController.popBackStack()
//                navController.navigateTo(LaunchRoute.List)
//            }
//        }
//        destination(LaunchRoute.List) {
//            ListScreen(goToAddEntry = {
//                navController.navigateTo(LaunchRoute.Add)
//            }) { entryId ->
//                navController.navigateTo(
//                    LaunchRoute.Details,
//                    LaunchRoute.Args.EntryId to entryId
//                )
//            }
//        }
//        destination(LaunchRoute.Details) {
//            val entryId = it.getArg<String>(LaunchRoute.Args.EntryId)
//            DetailsScreen(entryId.toLong()) {
//                navController.popBackStack()
//            }
//        }
//        destination(LaunchRoute.Add) {
//            AddScreen {
//                navController.popBackStack()
//            }
//        }
//    }
}
