package com.example.pulsetrack.model

import java.time.LocalDate

data class Steps(
    val id: String,
    val data: LocalDate,
    val count: Long,
    val goal: Long,
    val source: String
)
