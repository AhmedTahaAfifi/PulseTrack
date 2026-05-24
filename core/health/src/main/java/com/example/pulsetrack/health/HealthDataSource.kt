package com.example.pulsetrack.health

import com.example.pulsetrack.model.Steps
import kotlinx.coroutines.flow.Flow
import java.time.LocalDate

interface HealthDataSource {

    fun getStepsForData(data: LocalDate): Flow<Steps?>

    fun isAvailable(): Boolean

}