package com.psycodeinteractive.fbimostwanted.ui.feature.launch

import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.compose.runtime.Composable
import androidx.fragment.app.FragmentActivity
import com.psycodeinteractive.fbimostwanted.di.ScreenComponent

class LaunchActivity : FragmentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
//            Theme {
                ViewRoot()
//            }
        }
    }

    @Composable
    fun ViewRoot() {
//        ScreenComponent::class.create()
//        Navigation()

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
