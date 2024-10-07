package com.manriquetavi.jetatapp.navigation

import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.manriquetavi.jetatapp.features.detail.DetailScreen

fun NavGraphBuilder.detailsNavGraph(navController: NavHostController) {
    navigation(
        route = Graph.DETAIL,
        startDestination = Screen.Detail.route
    ) {
        composable(route = Screen.Detail.route) {
            DetailScreen()
        }
    }
}