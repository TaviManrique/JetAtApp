package com.manriquetavi.jetatapp.navigation

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import com.manriquetavi.jetatapp.features.history.HistoryScreen
import com.manriquetavi.jetatapp.features.home.HomeScreen
import com.manriquetavi.jetatapp.features.profile.ProfileScreen
import com.manriquetavi.jetatapp.features.setting.SettingScreen

@Composable
fun DrawerNavGraph(
    paddingValues: PaddingValues,
    drawerNavController: NavHostController,
    rootNavController: NavHostController
) {
    NavHost(
        navController = drawerNavController,
        route = Graph.DRAWER,
        startDestination = Screen.Home.route
    ) {
        composable(route = Screen.Home.route) {
            HomeScreen(
                paddingValues = paddingValues,
            )
        }
        composable(route = Screen.Profile.route) {
            ProfileScreen(
                paddingValues = paddingValues,
            )
        }
        composable(route = Screen.History.route) {
            HistoryScreen(
                paddingValues = paddingValues,
            )
        }
        composable(route = Screen.Setting.route) {
            SettingScreen(
                paddingValues = paddingValues,
            )
        }
        detailsNavGraph(drawerNavController)
    }
}