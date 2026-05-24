package com.example.pulsetrack.database.di

import android.content.Context
import androidx.room.Room
import com.example.pulsetrack.database.FitTrackerDatabase
import com.example.pulsetrack.database.dao.SleepDao
import com.example.pulsetrack.database.dao.StepsDao
import com.example.pulsetrack.database.dao.WorkoutDao
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DatabaseModule {

    @Provides
    @Singleton
    fun provideDatabase(@ApplicationContext context: Context): FitTrackerDatabase {
        return Room.databaseBuilder(
            context,
            FitTrackerDatabase::class.java,
            "pulsetrack_db"
        ).build()
    }

    @Provides
    fun provideStepsDao(db: FitTrackerDatabase): StepsDao = db.stepDao()

    @Provides
    fun provideWorkoutDao(db: FitTrackerDatabase): WorkoutDao = db.workoutDao()

    @Provides
    fun provideSleepDao(db: FitTrackerDatabase): SleepDao = db.sleepDao()

}