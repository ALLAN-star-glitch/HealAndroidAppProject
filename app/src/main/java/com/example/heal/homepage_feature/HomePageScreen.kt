package com.example.heal.homepage_feature

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color

@Composable
fun HomePageScreen(){
    Box(
        Modifier.background(MaterialTheme.colorScheme.primary)
    ) {
        Text(
            text = "HomePage",
            color = MaterialTheme.colorScheme.onPrimary,
            style = MaterialTheme.typography.titleLarge,

            )
    }
}