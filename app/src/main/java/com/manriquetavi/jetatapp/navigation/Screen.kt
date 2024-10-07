package com.manriquetavi.jetatapp.navigation

import kotlinx.serialization.Serializable

/*
@Serializable
sealed class Screen {
    @Serializable
    data object Main: Screen()
    @Serializable
    data object Login: Screen()
    @Serializable
    data object Register: Screen()
    @Serializable
    data object Home: Screen()
    @Serializable
    data object History: Screen()
    @Serializable
    data object Profile: Screen()
    @Serializable
    data object Detail: Screen()
    @Serializable
    data object Setting: Screen()
}*/

sealed class Screen(val route: String) {
    data object Home: Screen("home_screen")
    data object Login: Screen("login_screen")
    data object Register: Screen("register_screen")
    data object History: Screen("history_screen")
    data object Profile: Screen("profile_screen")
    data object Detail: Screen("detail_screen")
    data object Setting: Screen("setting_screen")
}