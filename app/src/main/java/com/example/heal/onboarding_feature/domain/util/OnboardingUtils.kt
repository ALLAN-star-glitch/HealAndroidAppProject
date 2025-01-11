//In this class, we store onboarding keys as preference datastore keys

package com.example.heal.onboarding_feature.domain.util


import android.content.Context
import androidx.datastore.preferences.core.booleanPreferencesKey
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.preferencesDataStore
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

// Extension property for DataStore
private val Context.dataStore by preferencesDataStore(name = "onboarding_prefs")

class OnboardingUtils(private val context: Context) {

    // Define a key for onboarding completion status
    companion object {
        private val ONBOARDING_COMPLETED_KEY = booleanPreferencesKey("onboarding_completed")
    }

    // Check if onboarding is completed
    val isOnboardingCompleted: Flow<Boolean> = context.dataStore.data.map { preferences ->
        preferences[ONBOARDING_COMPLETED_KEY] ?: false // Default to false if not set
    }

    // Set onboarding as completed
    suspend fun setOnboardingCompleted() {
        context.dataStore.edit { preferences ->
            preferences[ONBOARDING_COMPLETED_KEY] = true
        }
    }
}
