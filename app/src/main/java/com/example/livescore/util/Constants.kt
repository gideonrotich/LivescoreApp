package com.example.livescore.util

import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Color.Companion.Black
import androidx.compose.ui.graphics.Color.Companion.Blue
import androidx.compose.ui.res.colorResource
import com.example.livescore.R
import com.example.livescore.presentation.FilterContent

object Constants {
    const val BASE_URL = "https://app.sportdataapi.com/"

    const val API_KEY_TWO = "9ca19880-3dc1-11ed-8450-63ac23f45f39"

    const val GET_MATCHES = "api/v1/soccer/matches"

    const val PL_ID_MATCHES = "1980"

    const val GET_MATCH_DETAILS = "api/v1/soccer/matches/{id}"

    const val PARAM_MATCH_ID = "id"

    const val GET_STANDINGS = "api/v1/soccer/standings"

    val FILTER_CONTENT_LIST = listOf(
        FilterContent(R.drawable.premier_logo,Color.White, R.color.pink, "Premier League"),
        FilterContent(R.drawable.mylogo,Black, R.color.white, "Laliga"),
        FilterContent(R.drawable.test,Black, R.color.white, "Serie A"),
        FilterContent(R.drawable.league,Black, R.color.white, "League 1"),
        FilterContent(R.drawable.league,Black, R.color.white, "League 1")
    )
}