package com.zorder.tohuro.list

import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import cafe.adriel.voyager.core.screen.Screen
import cafe.adriel.voyager.koin.getScreenModel
import cafe.adriel.voyager.navigator.LocalNavigator
import cafe.adriel.voyager.navigator.currentOrThrow

internal class MoodListScreen :Screen{
    @Composable
    override fun Content() {
        val viewModel: MoodListScreenModel = getScreenModel ()
        val state by viewModel.state.collectAsState()
        val navigator = LocalNavigator.currentOrThrow

        if(state is MoodListScreenModel.State.Result){
            MoodListContent((state as MoodListScreenModel.State.Result).moods)
        }
    }

}