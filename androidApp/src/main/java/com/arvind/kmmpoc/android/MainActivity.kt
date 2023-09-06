package com.arvind.kmmpoc.android

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import com.arvind.kmmpoc.App
import com.arvind.kmmpoc.core.AppTheme
import com.arvind.kmmpoc.feature.case.CaseListScreen
import com.arvind.kmmpoc.feature.case.CaseListState

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            App(
                darkTheme = isSystemInDarkTheme(),
                dynamicColor = true,
            )
        }
    }
}


@Preview
@Composable
fun DefaultPreview() {
    AppTheme(darkTheme = true, dynamicColor = true) {
        CaseListScreen(state = CaseListState(), onEvent = {})
    }
}
