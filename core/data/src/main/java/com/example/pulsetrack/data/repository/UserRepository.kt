package com.example.pulsetrack.data.repository

import com.example.pulsetrack.model.UserGoals
import kotlinx.coroutines.flow.Flow

interface UserRepository {

    fun getUserGoals(): Flow<UserGoals>

    suspend fun updateDailyStepsGoal(steps: Long)

    suspend fun updateSleepHoursGoal(hours: Int)

}