package com.example.pulsetrack.model

import java.time.Instant

enum class SleepQuality {
    POOR,
    FAIR,
    GOOD;
}

data class SleepSession(
    val id: String,
    val startTime: Instant,
    val endTime: Instant,
    val durationMinutes: Int,
    val quality: SleepQuality,
    val source: String
)