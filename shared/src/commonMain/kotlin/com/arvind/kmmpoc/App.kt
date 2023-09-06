package com.arvind.kmmpoc

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import com.arvind.kmmpoc.core.AppTheme
import com.arvind.kmmpoc.feature.case.CaseListEvent
import com.arvind.kmmpoc.feature.case.CaseListScreen
import com.arvind.kmmpoc.feature.case.CaseViewModel
import dev.icerock.moko.mvvm.compose.getViewModel
import dev.icerock.moko.mvvm.compose.viewModelFactory

@Composable
fun App(
    darkTheme: Boolean,
    dynamicColor: Boolean,
) {
    AppTheme(
        darkTheme = darkTheme,
        dynamicColor = dynamicColor
    ) {
        val viewModel = getViewModel(
            key = "case-list-screen",
            factory = viewModelFactory {
                CaseViewModel()
            }
        )
        val state by viewModel.state.collectAsState()
        Surface(
            modifier = Modifier.fillMaxSize(),
            color = MaterialTheme.colorScheme.background
        ) {
            viewModel.onEvent(CaseListEvent.OnCaseListScreenLaunch)
            CaseListScreen(
                state = state,
                onEvent = viewModel::onEvent,
            )
        }
    }
}