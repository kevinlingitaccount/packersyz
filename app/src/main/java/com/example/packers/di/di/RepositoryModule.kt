package com.example.packers.di

import com.example.packers.data.network.service.ScheduleService
import com.example.packers.data.repository.ScheduleRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RepositoryModule {

    @Provides
    @Singleton
    fun providesScheduleRepository(scheduleService: ScheduleService): ScheduleRepository {
        return ScheduleRepository(scheduleService)
    }
}