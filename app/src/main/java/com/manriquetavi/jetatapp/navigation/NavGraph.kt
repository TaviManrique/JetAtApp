package com.manriquetavi.jetatapp.navigation

import androidx.compose.runtime.Composable
import androidx.lifecycle.Lifecycle
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.manriquetavi.jetatapp.features.main.MainScreen

@Composable
fun SetUpNavGraph(
    startDestination: String,
    rootNavController: NavHostController
) {
    NavHost(
        navController = rootNavController,
        route = Graph.ROOT,
        startDestination = startDestination
    ) {
        authNavGraph(rootNavController)
        composable(route = Graph.DRAWER) {
            MainScreen(
                rootNavController = rootNavController
            )
        }
    }

}

val NavHostController.canGoBack: Boolean
    get() = this.currentBackStackEntry?.lifecycle?.currentState == Lifecycle.State.RESUMED

object Graph{
    const val ROOT = "root_graph"
    const val AUTH = "auth_graph"
    const val DRAWER = "drawer_graph"
    const val DETAIL = "details_graph"
}

