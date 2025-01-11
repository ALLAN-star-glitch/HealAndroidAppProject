package com.example.heal.onboarding_feature.presentation

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.ColorScheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.Typography
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp




@Composable
fun OnboardingGraphUI(onboardingModel: OnboardingModel) {
    // Use Box to layer the blob background and image
    Box(
        modifier = Modifier.fillMaxSize()
    ) {

        // Main content
        Column(
            modifier = Modifier.fillMaxSize()
                .fillMaxSize()
                .padding(top = 300.dp), // Add padding to push the content down
            verticalArrangement = Arrangement.Top,// Arrange items from the top
            horizontalAlignment = Alignment.CenterHorizontally,

            ) {

            Spacer(modifier = Modifier.size(10.dp))

            //image

            Image(
                painter = painterResource(id = onboardingModel.image),
                contentDescription = null, // decorative, so no content description
                modifier = Modifier
                    .size(250.dp) // Adjust the size as needed
                    .padding(bottom = 16.dp) // Space between image and title
            )

            Spacer(modifier = Modifier.size(20.dp))

            // Title
            Text(
                text = onboardingModel.title,
                modifier = Modifier.fillMaxWidth(),
                fontSize = 20.sp,
                textAlign = TextAlign.Companion.Center,
                style = MaterialTheme.typography.titleLarge,
                color = Color.Black
            )

            Spacer(modifier = Modifier.size(15.dp))

            // Description
            Text(
                text = onboardingModel.description,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(25.dp, 0.dp),
                fontSize = 16.sp,
                textAlign = TextAlign.Companion.Center,
                style = MaterialTheme.typography.bodyLarge,
                color = Color.Black,
            )

            Spacer(modifier = Modifier.size(120.dp))
        }
    }
}

// Preview functions for the onboarding screens
@Preview(showBackground = true)
@Composable
fun OnboardingGraphUIPreview1() {
    OnboardingGraphUI(onboardingModel = OnboardingModel.FirstPage)
}

@Preview(showBackground = true)
@Composable
fun OnboardingGraphUIPreview2() {
    OnboardingGraphUI(onboardingModel = OnboardingModel.SecondPage)
}

@Preview(showBackground = true)
@Composable
fun OnboardingGraphUIPreview3() {
    OnboardingGraphUI(onboardingModel = OnboardingModel.ThirdPage)
}
