package com.example.myapplication.data.local.daos

import androidx.room.Dao
import androidx.room.Query
import com.example.myapplication.data.local.entities.ValueEntity
@Dao
interface ValueDao: BaseDao<ValueEntity> {

    @Query("SELECT * FROM weather_value ")
    fun findAll(): List<ValueEntity?>

   /* @Query("SELECT * FROM weather_value WHERE id = :id")
    suspend fun findOne(id: Long): ValueEntity?*/

}