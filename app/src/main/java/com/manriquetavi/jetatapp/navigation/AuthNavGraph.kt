package com.manriquetavi.jetatapp.navigation

import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.manriquetavi.jetatapp.features.login.LoginScreen
import com.manriquetavi.jetatapp.features.register.RegisterScreen

fun NavGraphBuilder.authNavGraph(
    rootNavController: NavHostController
) {
    navigation(
        route = Graph.AUTH,
        startDestination = Screen.Login.route
    ) {
        composable(route = Screen.Login.route) {
            LoginScreen(
                navigateToDrawer = { rootNavController.navigate(Graph.DRAWER) }
            )
        }
        composable(route = Screen.Register.route) {
            RegisterScreen()
        }
    }
}
