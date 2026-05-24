package com.example.pulsetrack.data.repository

import com.example.pulsetrack.datastore.UserPreferencesDataSource
import com.example.pulsetrack.model.UserGoals
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class OfflineFirstUserRepository @Inject constructor(
    private val userPreferencesDataSource: UserPreferencesDataSource
): UserRepository {

    override fun getUserGoals(): Flow<UserGoals> {
        return this.userPreferencesDataSource.userGoals
    }

    override suspend fun updateDailyStepsGoal(steps: Long) {
        this.userPreferencesDataSource.updateDailyStepsGoal(steps)
    }

    override suspend fun updateSleepHoursGoal(hours: Int) {
        this.userPreferencesDataSource.updateSleepHoursGoal(hours)
    }
}