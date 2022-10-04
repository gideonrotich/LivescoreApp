package com.example.livescore.presentation.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHost
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.livescore.presentation.Screen
import com.example.livescore.presentation.screens.matchdetails.MatchDetailsScreen
import com.example.livescore.presentation.screens.matches.MatchesScreen
import com.example.livescore.presentation.screens.scorers.components.ScorersScreen
import com.example.livescore.presentation.screens.standings.components.StandingScreen

@Composable
fun NavigationGraph(navController: NavHostController) {
    NavHost(navController, startDestination = BottomNavItem.Games.screen_route) {
        composable(BottomNavItem.Games.screen_route) {
            MatchesScreen(navController = navController)
        }
        composable(BottomNavItem.Standings.screen_route) {
            StandingScreen()
        }
        composable(BottomNavItem.Topscorer.screen_route) {
            ScorersScreen()
        }
        composable(
            route = Screen.MatchDetailsScreen.route + "/{id}"
        ) {
            MatchDetailsScreen()
        }
    }
}
