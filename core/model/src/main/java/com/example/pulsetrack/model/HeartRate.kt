package com.example.pulsetrack.model

import kotlin.time.Instant

data class HeartRate(
    val value: Int,
    val timestamp: Instant
)
