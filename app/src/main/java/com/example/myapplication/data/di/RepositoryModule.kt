package com.example.myapplication.data.di

import com.example.myapplication.data.repositories.IntervalRepository
import com.example.myapplication.data.repositories.IntervalRepositoryImpl
import com.example.myapplication.data.repositories.TimeLineRepository
import com.example.myapplication.data.repositories.TimeLineRepositoryImpl
import com.example.myapplication.data.repositories.ValueRepository
import com.example.myapplication.data.repositories.ValueRepositoryImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class RepositoryModule {
    @Singleton
    @Binds
    abstract fun provideIntervalRepositoryRepository(
        intervalRepositoryImpl: IntervalRepositoryImpl,
    ): IntervalRepository

    @Singleton
    @Binds
    abstract fun provideTimeLineRepository(
        timeLineRepositoryImpl: TimeLineRepositoryImpl,
    ): TimeLineRepository

    @Singleton
    @Binds
    abstract fun provideInterventionPointRepository(
        valueRepositoryImpl: ValueRepositoryImpl,
    ): ValueRepository


}