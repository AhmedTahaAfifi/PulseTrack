package com.example.pulsetrack.database.entity

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.time.LocalDate

@Entity(tableName = "steps")
data class StepsEntity(
    @PrimaryKey
    val date: LocalDate,
    val count: Long,
    val goal: Long,
    val source: String,
)
