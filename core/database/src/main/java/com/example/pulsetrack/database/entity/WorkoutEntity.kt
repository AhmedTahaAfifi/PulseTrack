package com.example.pulsetrack.database.entity

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.time.Instant

@Entity(tableName = "workouts")
data class WorkoutEntity(
    @PrimaryKey
    val id: String,
    val type: String,
    val startTime: Instant,
    val endTime: Instant,
    val distanceMeters: Double?,
    val calories: Int,
    val avgHeartRate: Int?,
    val routeJson: String?
)
