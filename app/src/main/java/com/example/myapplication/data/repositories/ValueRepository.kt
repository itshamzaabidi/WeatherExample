package com.example.myapplication.data.repositories

import com.example.myapplication.data.local.AppDatabase
import com.example.myapplication.data.local.entities.ValueEntity
import javax.inject.Inject

interface ValueRepository {

    fun finAll(): List<ValueEntity?>

    fun findOne(valueId: Long): ValueEntity?

}


class ValueRepositoryImpl @Inject constructor(
    private val appDatabase: AppDatabase,
) : ValueRepository {
    override fun finAll(): List<ValueEntity?> {
        return appDatabase.valueDao().findAll()
    }

    override fun findOne(valueId: Long): ValueEntity? {
       return appDatabase.valueDao().findOne(valueId)
    }

}