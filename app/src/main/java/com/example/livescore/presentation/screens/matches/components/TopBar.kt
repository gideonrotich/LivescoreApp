package com.example.livescore.presentation.screens.matches.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.InlineTextContent
import androidx.compose.foundation.text.appendInlineContent
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Call
import androidx.compose.material.icons.filled.Search
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.semantics.Role.Companion.Image
import androidx.compose.ui.text.Placeholder
import androidx.compose.ui.text.PlaceholderVerticalAlign
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.livescore.R

@Composable
fun TopBar(
    modifier: Modifier = Modifier
) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceAround,
        modifier = modifier
            .fillMaxWidth()
            .padding(top = 50.dp)

    ) {

        Card(
            shape = RoundedCornerShape(100.dp), modifier = Modifier
                .height(40.dp)
                .width(40.dp)
        ) {
            Row(modifier = Modifier.size(40.dp)) {
                Image(
                    painterResource(id = R.drawable.woma),
                    modifier = Modifier
                        .height(40.dp)
                        .width(40.dp)
                        .align(Alignment.CenterVertically),
                    contentDescription = "",
                    contentScale = ContentScale.FillWidth
                )
            }
        }

        Spacer(modifier = Modifier.width(20.dp))

        val annotatedString = buildAnnotatedString {
            append("Livesc")
            appendInlineContent(id = "imageId")
            append("re")
        }
        val inlineContentMap = mapOf(
            "imageId" to InlineTextContent(
                Placeholder(20.sp, 20.sp, PlaceholderVerticalAlign.TextCenter)
            ) {
                Image(
                    painterResource(id = R.drawable.reggae),
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(top = 4.dp),
                    contentDescription = ""
                )
            }
        )
        Text(
            annotatedString,
            inlineContent = inlineContentMap,
            fontSize = 30.sp,
            fontWeight = FontWeight.Bold
        )

        Spacer(modifier = Modifier.width(20.dp))
        Card(
            shape = RoundedCornerShape(100.dp), modifier = Modifier
                .height(40.dp)
                .width(40.dp)
        ) {
            Row(modifier = Modifier.size(20.dp)) {
                Image(
                    imageVector = Icons.Default.Search,
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(10.dp)
                        .align(Alignment.CenterVertically),
                    contentDescription = ""
                )
            }
        }

    }
}