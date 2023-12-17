package com.zorder.tohuro.list

import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import cafe.adriel.voyager.core.screen.Screen
import cafe.adriel.voyager.navigator.LocalNavigator
import cafe.adriel.voyager.navigator.currentOrThrow
import com.zorder.tohuro.detail.PersonDetailScreen
import com.zorder.tohuro.di.getScreenModel
import com.zorder.tohuro.list.PersonListScreenModel.State.Result

internal class PersonsListScreen : Screen {

    @Composable
     override fun Content() {
        val viewModel: PersonListScreenModel = getScreenModel()
        val state by viewModel.state.collectAsState()
        val navigator = LocalNavigator.currentOrThrow

        if (state is Result) {
            ListScreenContent((state as Result).persons) {
                navigator.push(PersonDetailScreen(it.id))
            }
        }
    }
}
