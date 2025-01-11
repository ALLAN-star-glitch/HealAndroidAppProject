package com.example.heal.onboarding_feature.presentation

import android.os.Build
import android.view.WindowInsetsController
import android.view.Window
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.SideEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.core.view.WindowCompat
import androidx.compose.ui.platform.LocalContext
import com.example.heal.ui.theme.HealTheme
import com.example.heal.R

@Composable
fun WelcomeScreen(
    onNavigateToNextScreen: () -> Unit
) {
    HealTheme {
        Box(modifier = Modifier.fillMaxSize()) {
            // Background image that extends into the status bar
            Image(
                painter = painterResource(id = R.drawable.bckground),
                contentDescription = "Welcome Background",
                modifier = Modifier.fillMaxSize(), // Make image cover the entire screen
                contentScale = ContentScale.Crop
            )

            // Overlay with opacity (semi-transparent black) for the image
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .background(Color.Black.copy(alpha = 0.4f)) // Semi-transparent overlay
            )

            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(16.dp),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Bottom
            ) {
                // Welcome text
                Text(
                    text = "Welcome to Heal",
                    style = MaterialTheme.typography.headlineMedium,
                    color = MaterialTheme.colorScheme.surface
                )

                Spacer(modifier = Modifier.height(30.dp))

                // Description or tagline
                Text(
                    text = "A journey to mental wellness begins here.",
                    style = MaterialTheme.typography.bodyLarge,
                    color = MaterialTheme.colorScheme.surface,
                    textAlign = TextAlign.Center,
                    modifier = Modifier.padding(horizontal = 20.dp)
                )

                Spacer(modifier = Modifier.height(40.dp))

                // Buttons
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(16.dp),
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Button(
                        onClick = onNavigateToNextScreen,
                        modifier = Modifier.weight(1f),
                        colors = androidx.compose.material3.ButtonDefaults.buttonColors(
                            containerColor = MaterialTheme.colorScheme.primary,
                            contentColor = MaterialTheme.colorScheme.onPrimary
                        )
                    ) {
                        Text("Login", style = MaterialTheme.typography.labelLarge)
                    }

                    Button(
                        onClick = onNavigateToNextScreen,
                        modifier = Modifier.weight(1f),
                        colors = androidx.compose.material3.ButtonDefaults.buttonColors(
                            containerColor = MaterialTheme.colorScheme.primary,
                            contentColor = MaterialTheme.colorScheme.onPrimary
                        )
                    ) {
                        Text("Get Started", style = MaterialTheme.typography.labelLarge)
                    }
                }

                // Powered by text
                Text(
                    text = "Powered By Jeillan Technologies & Susan Gitau Counseling Foundation",
                    style = MaterialTheme.typography.bodySmall.copy(
                        fontWeight = FontWeight.Normal,
                        fontSize = 12.sp,
                        fontStyle = FontStyle.Italic
                    ),
                    color = MaterialTheme.colorScheme.surface,
                    textAlign = TextAlign.Center,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(16.dp)
                )

                Spacer(Modifier.height(100.dp))
            }
        }
    }
}


@Preview(showBackground = true)
@Composable
fun WelcomeScreenPreview() {
    WelcomeScreen(onNavigateToNextScreen = {})
}
