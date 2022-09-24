package com.example.livescore

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.livescore.presentation.Screen
import com.example.livescore.presentation.screens.matchdetails.MatchDetailsScreen
import com.example.livescore.presentation.screens.matches.MatchesScreen
import com.example.livescore.ui.theme.LivescoreTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val navController = rememberNavController()
            NavHost(
                navController = navController,
                startDestination = Screen.MatchScreen.route
            ) {
                composable(
                    route = Screen.MatchScreen.route
                ) {
                    MatchesScreen(navController)
                }
                composable(
                    route = Screen.MatchDetailsScreen.route + "/{id}"
                ) {
                    MatchDetailsScreen()
                }

            }
        }
    }
}

