package com.example.pulsetrack.health.di

import android.content.Context
import com.example.pulsetrack.health.HuaweiHealthSource
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object HealthModule {

    @Provides
    @Singleton
    fun provideHuaweiHealthSource(
        @ApplicationContext context: Context
    ): HuaweiHealthSource = HuaweiHealthSource(context)

}