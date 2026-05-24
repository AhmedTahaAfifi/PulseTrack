package com.example.pulsetrack.model

import java.time.LocalDate

data class Steps(
    val id: String,
    val date: LocalDate,
    val count: Long,
    val goal: Long,
    val source: String
)
