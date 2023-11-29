package com.zorder.tohuro.list

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.zorder.tohuro.model.Mood

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MoodListContent(
    moods: List<Mood>,
)
{
    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Row(
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.SpaceBetween
                    ) {
                        Text("KMP Starter OS")
                    }
                }
            )
        }
    ) { paddingValues ->
        LazyColumn(
            Modifier
                .padding(paddingValues)
                .padding(32.dp)
        ) {
            items(moods) { mood ->
                Row(verticalAlignment = Alignment.CenterVertically) {

                    Spacer(Modifier.width(4.dp))
                    TextButton({

                    }) {
                        Text("See more info about ${mood.name}")
                    }
                }
            }
        }
    }
}