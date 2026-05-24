package com.example.pulsetrack.datastore

import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.booleanPreferencesKey
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.intPreferencesKey
import androidx.datastore.preferences.core.longPreferencesKey
import com.example.pulsetrack.model.UserGoals
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class UserPreferencesDataSource @Inject constructor(
    private val dataStore: DataStore<Preferences>
) {

    private object PreferencesKeys {
        val DAILY_STEPS_GOAL = longPreferencesKey("daily_steps_goal")
        val SLEEP_HOURS_GOAL = intPreferencesKey("sleep_hours_goal")
        val CALORIE_TARGET = intPreferencesKey("calorie_target")
        val USE_DARK_MODE = booleanPreferencesKey("use_dark_mode")
    }

    val userGoals: Flow<UserGoals> = this.dataStore.data.map { preferences ->
        UserGoals(
            dailySteps = preferences[PreferencesKeys.DAILY_STEPS_GOAL] ?: 10000L,
            sleepHours = preferences[PreferencesKeys.SLEEP_HOURS_GOAL] ?: 8,
            calorieTarget = preferences[PreferencesKeys.CALORIE_TARGET] ?: 2500
        )
    }

    val useDarkMode: Flow<Boolean> = this.dataStore.data.map { preferences ->
        preferences[PreferencesKeys.USE_DARK_MODE] ?: false
    }

    suspend fun updateDailyStepsGoal(steps: Long) {
        this.dataStore.edit { preferences ->
            preferences[PreferencesKeys.DAILY_STEPS_GOAL] = steps
        }
    }

    suspend fun updateSleepHoursGoal(hours: Int) {
        this.dataStore.edit { preferences ->
            preferences[PreferencesKeys.SLEEP_HOURS_GOAL] = hours
        }
    }

    suspend fun updateCalorieTarget(calories: Int) {
        this.dataStore.edit { preferences ->
            preferences[PreferencesKeys.CALORIE_TARGET] = calories
        }
    }

    suspend fun setDarkMode(enabled: Boolean) {
        this.dataStore.edit { preferences ->
            preferences[PreferencesKeys.USE_DARK_MODE] = enabled
        }
    }

}