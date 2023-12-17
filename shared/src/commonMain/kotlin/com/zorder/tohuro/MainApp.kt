package com.zorder.tohuro

import androidx.compose.runtime.Composable
import cafe.adriel.voyager.navigator.Navigator
import cafe.adriel.voyager.transitions.SlideTransition
import com.zorder.tohuro.list.PersonsListScreen

@Composable
fun MainApp() {
    Navigator(PersonsListScreen()) { navigator ->
        SlideTransition(navigator)
    }
}
