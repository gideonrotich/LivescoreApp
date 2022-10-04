package com.example.livescore.presentation.screens.matches

import android.content.Context
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import coil.compose.rememberAsyncImagePainter
import coil.compose.rememberImagePainter
import coil.request.ImageRequest
import coil.size.Size
import com.example.livescore.R
import com.example.livescore.presentation.FilterContent
import com.example.livescore.presentation.Screen
import com.example.livescore.presentation.screens.matches.components.LiveMatchItem
import com.example.livescore.presentation.screens.matches.components.MatchesViewModel
import com.example.livescore.presentation.screens.matches.components.TopBar
import com.example.livescore.presentation.screens.matches.components.UpcomingMatchesItem
import com.example.livescore.util.Constants.FILTER_CONTENT_LIST
import com.example.livescore.util.gifLoader

@Composable
fun MatchesScreen(
    navController: NavController,
    matchesViewModel: MatchesViewModel = hiltViewModel()
) {
    val matchesState = matchesViewModel.state.value
    val context = LocalContext.current

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(color = colorResource(id = R.color.whiter))
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
        ) {
            TopBar()
            Spacer(Modifier.height(4.dp))

            FilterOptionsComponent()

            Spacer(Modifier.height(6.dp))
            Text(
                text = "Live Matches",
                style = MaterialTheme.typography.body1,
                color = Color.Black,
                fontSize = 18.sp,
                fontWeight = FontWeight.Bold,
                modifier = Modifier.padding(start = 20.dp)
            )
            LazyRow(modifier = Modifier.fillMaxWidth()) {
                items(matchesState.matches) { matches ->
                    LiveMatchItem(match = matches, onItemClicked = {
                        navController.navigate(Screen.MatchDetailsScreen.route + "/${matches.match_id}")
                    })
                }
            }
            Text(
                text = "Upcoming Matches",
                style = MaterialTheme.typography.body1,
                color = Color.Black,
                fontSize = 18.sp,
                fontWeight = FontWeight.Bold,
                modifier = Modifier.padding(start = 20.dp)
            )

            LazyColumn(modifier = Modifier.fillMaxWidth()) {
                items(matchesState.matches) { matches ->
                    UpcomingMatchesItem(match = matches, onItemClicked = {
                        navController.navigate(Screen.MatchDetailsScreen.route + "/${matches.match_id}")
                    })
                }
            }
        }
        if (matchesState.error.isNotBlank()) {
            Text(
                text = matchesState.error,
                color = MaterialTheme.colors.error,
                textAlign = TextAlign.Center,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 20.dp)
                    .align(Alignment.Center)
            )
        }
        if (matchesState.isLoading) {
            CircularProgressIndicator(
                modifier = Modifier.align(Alignment.Center),
                color = colorResource(
                    id = R.color.purple
                )
            )
        }
    }
}

@Composable
fun FilterOptionsComponent() {
    val filterOptions = FILTER_CONTENT_LIST
    LazyRow(
        Modifier.padding(top = 15.dp, start = 15.dp),
        horizontalArrangement = Arrangement.spacedBy(10.dp)
    ) {
        items(filterOptions.size) {
            ChipComponent(filter = filterOptions[it])
        }
    }
}

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun ChipComponent(filter: FilterContent) {
    val contentColor = filter.contentColor
    val chipBackground = filter.backgroundColor
    val filterText = filter.filterText
    val logo = filter.logo
    Chip(
        onClick = { /*TODO*/ },
        colors = ChipDefaults.chipColors(
            contentColor = contentColor,
            backgroundColor = colorResource(id = chipBackground)
        ),
        shape = RoundedCornerShape(60.dp)
    ) {
        Row(modifier = Modifier.height(40.dp)) {
            val image: Painter = rememberImagePainter(data = logo)

            Image(
                modifier = Modifier
                    .height(20.dp)
                    .width(20.dp)
                    .clip(RoundedCornerShape(8.dp))
                    .align(Alignment.CenterVertically),
                painter = image,
                alignment = Alignment.Center,
                contentDescription = "",
                contentScale = ContentScale.Crop
            )
            Spacer(modifier = Modifier.width(6.dp))
            Text(text = filterText, modifier = Modifier.align(Alignment.CenterVertically))
        }
    }
}

@Composable
fun LoadingGif(
    context: Context,
    modifier: Modifier = Modifier
) {
    Image(
        painter = rememberAsyncImagePainter(
            ImageRequest.Builder(context).data(data = R.drawable.bouncel).apply(block = {
                size(Size.ORIGINAL)
            }).build(),
            imageLoader = context.gifLoader()
        ),
        contentDescription = null,
        modifier = modifier
            .fillMaxWidth()
            .height(90.dp)
    )
}
