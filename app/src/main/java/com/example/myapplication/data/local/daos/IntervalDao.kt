package com.example.myapplication.data.local.daos

import androidx.room.Dao
import androidx.room.Query
import com.example.myapplication.data.local.entities.IntervalEntity
@Dao
interface IntervalDao: BaseDao<IntervalEntity> {

    @Query("SELECT * FROM interval ")
    fun findAll(): List<IntervalEntity?>

    /*@Query("SELECT * FROM interval WHERE id = :id")
    suspend fun findOne(id: Long): IntervalEntity?*/

}