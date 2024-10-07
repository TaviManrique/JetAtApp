package com.manriquetavi.jetatapp.features.main

import androidx.activity.compose.BackHandler
import androidx.compose.animation.core.animateDpAsState
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.scale
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.manriquetavi.jetatapp.common.component.nav_drawer.AtDrawer
import com.manriquetavi.jetatapp.common.model.AtDrawerState
import com.manriquetavi.jetatapp.common.model.NavigationItem
import com.manriquetavi.jetatapp.common.model.isOpen
import com.manriquetavi.jetatapp.common.model.opposite
import com.manriquetavi.jetatapp.navigation.DrawerNavGraph
import com.manriquetavi.jetatapp.util.coloredShadow
import kotlin.math.roundToInt

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MainScreen(
    rootNavController: NavHostController
) {
    var drawerState by remember { mutableStateOf(AtDrawerState.Closed) }
    var selectedNavigationItem by remember { mutableStateOf(NavigationItem.Home) }

    val density = LocalDensity.current.density
    val configuration = LocalConfiguration.current

    val screenWidth = remember {
        derivedStateOf { (configuration.screenWidthDp * density).roundToInt() }
    }
    val offsetValue by remember {
        derivedStateOf { (screenWidth.value/4.5).dp }
    }
    val animatedOffset by animateDpAsState(
        targetValue = if (drawerState.isOpen()) offsetValue else 0.dp,
        label = "Animated Offset"
    )
    val animatedScale by animateFloatAsState(
        targetValue = if (drawerState.isOpen()) 0.9f else 1f,
        label = "Animated Scale"
    )
    val drawerNavController = rememberNavController()
    Box(
        modifier = Modifier
            .background(MaterialTheme.colorScheme.surface)
            .statusBarsPadding()
            .navigationBarsPadding()
            .fillMaxSize()
    ) {
        val drawers = NavigationItem.entries
        val navBackStackEntry by drawerNavController.currentBackStackEntryAsState()
        val currentDestination = navBackStackEntry?.destination
        val shouldShowAtDrawer = drawers.any { it.route == currentDestination?.route }
        if (shouldShowAtDrawer) {
            AtDrawer(
                selectedNavigationItem = selectedNavigationItem,
                onNavigationItemClick = { selectedNavigationItem = it },
                onCloseClick = { drawerState = AtDrawerState.Closed },
                drawerNavController = drawerNavController
            )
        }
        Scaffold(
            modifier = Modifier
                .offset(x = animatedOffset)
                .scale(scale = animatedScale)
                .coloredShadow(
                    color = Color.Black, alpha = 0.1f, shadowRadius = 50.dp
                )
                .clickable(enabled = drawerState == AtDrawerState.Opened) {
                    drawerState = AtDrawerState.Closed
                },
            topBar = {
                TopAppBar(
                    title = {
                        Text(
                            text = buildAnnotatedString {
                                withStyle(style = SpanStyle(color = Color.Red)) {
                                    append("apuesta")
                                }
                                withStyle(style = SpanStyle(color = Color.Black)) {
                                    append("total")
                                }
                            },
                            fontWeight = FontWeight.ExtraBold
                        )
                    },
                    navigationIcon = {
                        IconButton(onClick = { drawerState = drawerState.opposite() }) {
                            Icon(
                                imageVector = Icons.Default.Menu,
                                contentDescription = "Menu Icon"
                            )
                        }
                    }
                )
            }
        ) { paddingValues ->
            DrawerNavGraph(
                paddingValues = paddingValues,
                rootNavController = rootNavController,
                drawerNavController = drawerNavController
            )
        }
    }
    BackHandler(enabled = drawerState.isOpen()) {
        drawerState = AtDrawerState.Closed
    }
}