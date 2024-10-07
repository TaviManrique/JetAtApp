package com.manriquetavi.jetatapp.common.model

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material.icons.filled.Timeline
import androidx.compose.ui.graphics.vector.ImageVector

enum class NavigationItem(
    val title: String,
    val route: String,
    val icon: ImageVector
) {
    Home(
        title = "Home",
        route = "home_screen",
        icon = Icons.Filled.Home
    ),
    Profile(
        title = "Profile",
        route = "profile_screen",
        icon = Icons.Filled.Person
    ),
    History(
        title = "History",
        route = "history_screen",
        icon = Icons.Filled.Timeline
    ),
    Setting(
        title = "Setting",
        route = "setting_screen",
        icon = Icons.Filled.Settings
    )
}