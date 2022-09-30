package com.example.livescore.presentation.navigation

import com.example.livescore.R

sealed class BottomNavItem(var title:String, var icon:Int, var screen_route:String){
    object Games : BottomNavItem("Games", R.drawable.ic_games,"games")
    object Standings: BottomNavItem("Standings",R.drawable.ic_league,"standings")

}
