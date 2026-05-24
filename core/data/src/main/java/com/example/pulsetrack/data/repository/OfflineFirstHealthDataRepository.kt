package com.example.pulsetrack.data.repository

import com.example.pulsetrack.database.dao.SleepDao
import com.example.pulsetrack.database.dao.StepsDao
import com.example.pulsetrack.database.dao.WorkoutDao
import com.example.pulsetrack.model.SleepQuality
import com.example.pulsetrack.model.SleepSession
import com.example.pulsetrack.model.Steps
import com.example.pulsetrack.model.WorkoutSession
import com.example.pulsetrack.model.WorkoutType
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import java.time.LocalDate
import javax.inject.Inject

class OfflineFirstHealthDataRepository @Inject constructor(
    private val stepsDao: StepsDao,
    private val workoutDao: WorkoutDao,
    private val sleepDao: SleepDao
): HealthDataRepository {

    override fun getStepsForDate(date: LocalDate): Flow<Steps?> {
        return this.stepsDao.getStepsForDate(date).map { entity ->
            entity?.let {
                Steps(
                    id = it.date.toString(),
                    date = it.date,
                    count = it.count,
                    goal = it.goal,
                    source = it.source
                )
            }
        }
    }

    override fun getWeeklySteps(): Flow<List<Steps>> {
        return this.stepsDao.getWeeklySteps().map { list ->
            list.map {
                Steps(
                    id = it.date.toString(),
                    date = it.date,
                    count = it.count,
                    goal = it.goal,
                    source = it.source
                )
            }
        }
    }

    override fun getAllWorkouts(): Flow<List<WorkoutSession>> {
        return this.workoutDao.getAllWorkouts().map { list ->
            list.map {
                WorkoutSession(
                    id = it.id,
                    type = WorkoutType.valueOf(it.type),
                    startTime = it.startTime,
                    endTime = it.endTime,
                    distanceMeters = it.distanceMeters,
                    calories = it.calories,
                    avgHeartRate = it.avgHeartRate,
                    routeJson = it.routeJson
                )
            }
        }
    }

    override fun getAllSleepSessions(): Flow<List<SleepSession>> {
        return this.sleepDao.getAllSleepSessions().map { list ->
            list.map {
                SleepSession(
                    id = it.id,
                    startTime = it.startTime,
                    endTime = it.endTime,
                    durationMinutes = it.durationMinutes,
                    quality = SleepQuality.valueOf(it.quality),
                    source = it.source
                )
            }
        }
    }

    override suspend fun syncHealthData() {
        //TODO("Not yet implemented")
    }
}