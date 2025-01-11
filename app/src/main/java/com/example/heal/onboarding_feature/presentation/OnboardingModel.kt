package com.example.heal.onboarding_feature.presentation

sealed class OnboardingModel(
    val image: Int,
    val title: String,
    val description: String,
) {

    data object FirstPage : OnboardingModel(
        image = com.example.heal.R.drawable.onboardingimage1,
        title = "Welcome to Heal: Your Journey to Wellness Begins Here",
        description = "Start your path to better mental health. Heal provides expert counseling, mental wellness tools, and community support to help you feel your best, every day."
    )

    data object SecondPage : OnboardingModel(
        image = com.example.heal.R.drawable.onboardingimage2,
        title = "Get Tailored Support Just for You",
        description = "Our licensed counselors offer personalized support through one-on-one sessions and group counseling. Heal connects you with the right resources for your mental health needs."
    )

    data object ThirdPage : OnboardingModel(
        image = com.example.heal.R.drawable.onboardingimage3,
        title = "Track Your Progress & Connect in Real-Time",
        description = "Stay on top of your mental wellness journey with real-time tracking and instant communication with your counselor. Get the support you need, when you need it."
    )
}
