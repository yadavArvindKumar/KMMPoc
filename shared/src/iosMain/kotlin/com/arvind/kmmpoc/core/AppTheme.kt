package com.arvind.kmmpoc.core

import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import com.arvind.kmmpoc.theme.DarkColorScheme
import com.arvind.kmmpoc.theme.LightColorScheme
import com.arvind.kmmpoc.theme.Typography


@Composable
actual fun AppTheme(
    darkTheme: Boolean,
    dynamicColor: Boolean,
    content: @Composable () -> Unit
) {
    MaterialTheme(
        colorScheme = if (darkTheme) DarkColorScheme else LightColorScheme,
        typography = Typography,
        content = content
    )
}