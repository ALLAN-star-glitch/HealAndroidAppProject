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
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
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
        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(
                    brush = Brush.linearGradient(
                        colors = listOf(
                            Color(0xFF6A0DAD), // Purple
                            Color(0xFF9B4DFF), // Light Purple
                            Color(0xFFAB7BFF), // Lavender
                            Color(0xFFD0A5FF)  // Light Lavender
                        ),
                        start = Offset(1000f, 1000f),
                        end = Offset(0f, 0f) // Diagonal gradient
                    )
                )

        ) {

            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(16.dp),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Bottom
            ) {

                // Logo
                Image(
                    painter = painterResource(id = R.drawable.logotwo), // Replace with your logo's resource ID
                    contentDescription = "App Logo",
                    modifier = Modifier
                        .size(250.dp) // Adjust size as needed
                        .padding(bottom = 16.dp),
                    contentScale = ContentScale.Fit
                )

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
                    horizontalArrangement = Arrangement.Center
                ) {
                    Button(
                        onClick = onNavigateToNextScreen,
                        modifier = Modifier
                            .weight(1f)
                            .padding(end = 8.dp), // Add spacing on the right
                        colors = androidx.compose.material3.ButtonDefaults.buttonColors(
                            containerColor = MaterialTheme.colorScheme.primary,
                            contentColor = MaterialTheme.colorScheme.onPrimary
                        )
                    ) {
                        Text("Login", style = MaterialTheme.typography.labelLarge)
                    }

                    Button(
                        onClick = onNavigateToNextScreen,
                        modifier = Modifier
                            .weight(1f)
                            .padding(start = 8.dp), // Add spacing on the left
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
