package com.example.pulsetrack.model

import java.time.Instant

enum class WorkoutType {
    RUN,
    WALK,
    GYM,
    OTHER;
}

data class WorkoutSession(
    val id: String,
    val type: WorkoutType,
    val startTime: Instant,
    val endTime: Instant,
    val distanceMeters: Double?,
    val calories: Int?,
    val avgHeartRate: Int?,
    val routeJson: String?
)