package com.example.myapplication.data.local.daos

import androidx.room.Dao
import androidx.room.Query
import com.example.myapplication.data.local.entities.TimeLineEntity
@Dao
interface TimeLineDao : BaseDao<TimeLineEntity> {



    @Query("SELECT * FROM time_line ")
    fun findAll(): List<TimeLineEntity?>

    @Query("SELECT * FROM time_line WHERE id = :id")
     fun findOne(id: Long): TimeLineEntity?

}