package com.example.livescore.presentation.screens.odds

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.livescore.data.remote.dto.odds.Bookmaker

@Composable
fun OddsScreen(book:List<Bookmaker>){

    Box(modifier = Modifier.fillMaxSize()){
        Column(modifier = Modifier
            .fillMaxSize()
            .padding(20.dp)) {
           LazyColumn(){
               items(items = book){books ->
                   Text(text = books.bookmaker_name)
               }
           }
        }
    }

}