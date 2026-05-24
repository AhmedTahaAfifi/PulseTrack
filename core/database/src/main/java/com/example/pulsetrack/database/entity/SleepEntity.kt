package com.example.pulsetrack.database.entity

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.time.Instant

@Entity(tableName = "sleep_sessions")
data class SleepEntity(
    @PrimaryKey
    val id: String,
    val startTime: Instant,
    val endTime: Instant,
    val durationMinutes: Int,
    val quality: String,
    val source: String
)
