package com.example.packers.di

import com.example.packers.data.network.RetrofitInstance
import com.example.packers.data.network.service.SCHEDULE_BASE_URL
import com.example.packers.data.network.service.ScheduleService
import com.squareup.moshi.Moshi
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object NetworkModule {

    @Provides
    @Singleton
    fun providesMoshi(): Moshi {
        return Moshi.Builder().build()
    }

    @Provides
    @Singleton
    fun providesRetrofitInstance(moshi: Moshi): Retrofit {
        return RetrofitInstance(SCHEDULE_BASE_URL, moshi).providesRetrofit()
    }

    @Provides
    @Singleton
    fun providesScheduleService(retrofit: Retrofit): ScheduleService {
        return retrofit.create(ScheduleService::class.java)
    }
}