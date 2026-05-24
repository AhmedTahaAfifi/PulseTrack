package com.example.pulsetrack.database

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.example.pulsetrack.database.dao.SleepDao
import com.example.pulsetrack.database.dao.StepsDao
import com.example.pulsetrack.database.dao.WorkoutDao
import com.example.pulsetrack.database.entity.SleepEntity
import com.example.pulsetrack.database.entity.StepsEntity
import com.example.pulsetrack.database.entity.WorkoutEntity

@Database(
    entities = [
        StepsEntity::class,
        WorkoutEntity::class,
        SleepEntity::class
    ],
    version = 1,
    exportSchema = false
)
@TypeConverters(Converters::class)
abstract class FitTrackerDatabase: RoomDatabase() {

    abstract fun stepDao(): StepsDao

    abstract fun workoutDao(): WorkoutDao

    abstract fun sleepDao(): SleepDao

}