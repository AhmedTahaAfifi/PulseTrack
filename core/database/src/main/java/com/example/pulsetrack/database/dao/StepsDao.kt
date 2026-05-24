package com.example.pulsetrack.database.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.pulsetrack.database.entity.StepsEntity
import kotlinx.coroutines.flow.Flow
import java.time.LocalDate

@Dao
interface StepsDao {

    @Query("SELECT * FROM steps WHERE date = :date")
    fun getStepsForDate(date: LocalDate): Flow<StepsEntity?>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertSteps(steps: StepsEntity)

    @Query("SELECT * FROM steps ORDER BY date DESC LIMIT 7")
    fun getWeeklySteps(): Flow<List<StepsEntity>>

}