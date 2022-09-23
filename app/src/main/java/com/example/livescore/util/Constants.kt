package com.example.livescore.util

import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Color.Companion.Black
import androidx.compose.ui.graphics.Color.Companion.Blue
import androidx.compose.ui.res.colorResource
import com.example.livescore.R
import com.example.livescore.presentation.FilterContent

object Constants {
    const val BASE_URL = "https://app.sportdataapi.com/"


    const val API_KEY_TWO = "5854abc0-36b8-11ed-b9f8-af3e9ecb0bee"

    const val GET_MATCHES = "api/v1/soccer/matches"

    const val PL_ID_MATCHES = "1980"

    val FILTER_CONTENT_LIST = listOf(
        FilterContent(R.drawable.premier_logo,Color.White, R.color.pink, "Premier League"),
        FilterContent(R.drawable.mylogo,Black, R.color.white, "Laliga"),
        FilterContent(R.drawable.test,Black, R.color.white, "Serie A"),
        FilterContent(R.drawable.league,Black, R.color.white, "League 1"),
    )
}