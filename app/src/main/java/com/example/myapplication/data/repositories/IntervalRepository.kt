package com.example.myapplication.data.repositories

import com.example.myapplication.data.local.AppDatabase
import com.example.myapplication.data.local.entities.IntervalEntity
import javax.inject.Inject

interface IntervalRepository {

    fun finAll(): List<IntervalEntity>

    fun findOne(intervalId: Long): IntervalEntity

}


class IntervalRepositoryImpl @Inject constructor(
    private val appDatabase: AppDatabase,
) : IntervalRepository {
    override fun finAll(): List<IntervalEntity> {
        TODO("Not yet implemented")
    }

    override fun findOne(intervalId: Long): IntervalEntity {
        TODO("Not yet implemented")
    }

}