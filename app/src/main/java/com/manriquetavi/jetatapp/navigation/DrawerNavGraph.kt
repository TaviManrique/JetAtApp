package com.manriquetavi.jetatapp.navigation

import androidx.activity.compose.BackHandler
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.navigation.compose.NavHost
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import com.manriquetavi.jetatapp.common.model.ChipFilter
import com.manriquetavi.jetatapp.features.detail.DetailScreen
import com.manriquetavi.jetatapp.features.history.HistoryScreen
import com.manriquetavi.jetatapp.features.history.HistoryViewModel
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
            val viewModel: HistoryViewModel = hiltViewModel()
            val uiState by viewModel.uiState.collectAsStateWithLifecycle()
            val chips = ChipFilter.entries.toTypedArray().dropLast(1)
            HistoryScreen(
                uiState = uiState,
                paddingValues = paddingValues,
                chips = chips,
                searchByStatus = { viewModel.filterByStatus(it) },
                navigateToDetail = { drawerNavController.navigate(Screen.Detail.createRoute(it))  }
            )
        }
        composable(route = Screen.Setting.route) {
            SettingScreen(
                paddingValues = paddingValues,
            )
        }
        composable(route = Screen.Detail.route) {
            DetailScreen()
        }
    }
}