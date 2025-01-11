package com.example.heal

import android.os.Build
import android.os.Bundle
import android.view.WindowInsetsController
import android.view.WindowManager
import android.view.View
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.ui.Modifier
import androidx.core.view.WindowCompat
import com.example.heal.core_feature.presentation.NavHostSetup
import com.example.heal.onboarding_feature.domain.util.OnboardingUtils
import com.example.heal.ui.theme.HealTheme

class MainActivity : ComponentActivity() {
    private lateinit var onboardingUtils: OnboardingUtils

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Enable edge-to-edge UI
        enableEdgeToEdge()

        onboardingUtils = OnboardingUtils(this)

        // Set the content view after UI setup
        setContent {
            HealTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    NavHostSetup(
                        onboardingUtils,
                        Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }

    // Override onWindowFocusChanged to modify system UI when the window is ready
    override fun onWindowFocusChanged(hasFocus: Boolean) {
        super.onWindowFocusChanged(hasFocus)                   
        if (hasFocus) {
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.R) {
                window.insetsController?.let { controller ->
                    controller.hide(WindowInsetsController.BEHAVIOR_SHOW_BARS_BY_SWIPE)  // Hide system bars by swipe
                    controller.systemBarsBehavior = WindowInsetsController.BEHAVIOR_SHOW_TRANSIENT_BARS_BY_SWIPE  // Auto hide system bars when swiped
                }
                window.statusBarColor = android.graphics.Color.TRANSPARENT  // Make status bar transparent
            } else {
                @Suppress("DEPRECATION")
                window.decorView.systemUiVisibility = (
                        View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN or
                                View.SYSTEM_UI_FLAG_LAYOUT_STABLE
                        )
                window.statusBarColor = android.graphics.Color.TRANSPARENT  // Make status bar transparent
            }
        }
    }
}
