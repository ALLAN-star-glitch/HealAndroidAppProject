package com.example.heal.core_feature.presentation

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.heal.homepage_feature.HomePageScreen
import com.example.heal.onboarding_feature.domain.util.OnboardingUtils
import com.example.heal.onboarding_feature.presentation.OnboardingScreen
import com.example.heal.onboarding_feature.presentation.WelcomeScreen
import kotlinx.coroutines.launch

@Composable
fun NavHostSetup(onboardingUtils: OnboardingUtils, modifier: Modifier = Modifier) {
    val navController = rememberNavController()
    val scope = rememberCoroutineScope()

    // State to hold onboarding completion status
    var isOnboardingCompleted by remember { mutableStateOf(false) }

    // Collect onboarding status asynchronously
    LaunchedEffect(Unit) {
        onboardingUtils.isOnboardingCompleted.collect { completed ->
            isOnboardingCompleted = completed
        }
    }

    Scaffold { innerPadding ->
        NavHost(
            navController = navController,
            startDestination = "welcome",
            Modifier.padding(innerPadding)
        ) {
            // Welcome Screen
            composable("welcome") {
                WelcomeScreen {
                    navController.navigate("onboarding") // Navigate to onboarding when Get Started is clicked
                }
            }

            // Onboarding Screen
            composable("onboarding") {
                OnboardingScreen {
                    scope.launch {
                        onboardingUtils.setOnboardingCompleted()
                        navController.navigate("homeScreen") // Navigate to home screen after onboarding
                    }
                }
            }

            // Home Screen
            composable("homeScreen") {
                HomePageScreen()
            }
        }
    }
}
