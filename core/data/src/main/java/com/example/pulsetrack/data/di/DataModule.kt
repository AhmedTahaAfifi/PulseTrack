package com.example.pulsetrack.data.di

import com.example.pulsetrack.data.repository.HealthDataRepository
import com.example.pulsetrack.data.repository.OfflineFirstHealthDataRepository
import com.example.pulsetrack.data.repository.OfflineFirstUserRepository
import com.example.pulsetrack.data.repository.UserRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class DataModule {

    @Binds
    @Singleton
    abstract fun bindHealthDateRepository(
        implementation: OfflineFirstHealthDataRepository
    ): HealthDataRepository

    @Binds
    @Singleton
    abstract fun bindUserRepository(
        implementation: OfflineFirstUserRepository
    ): UserRepository

}