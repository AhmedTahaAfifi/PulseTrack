package com.example.pulsetrack.data.repository

import com.example.pulsetrack.model.SleepSession
import com.example.pulsetrack.model.Steps
import com.example.pulsetrack.model.WorkoutSession
import kotlinx.coroutines.flow.Flow
import java.time.LocalDate

interface HealthDataRepository {

    fun getStepsForDate(date: LocalDate): Flow<Steps?>

    fun getWeeklySteps(): Flow<List<Steps>>

    fun getAllWorkouts(): Flow<List<WorkoutSession>>

    fun getAllSleepSessions(): Flow<List<SleepSession>>

    suspend fun syncHealthData()

}