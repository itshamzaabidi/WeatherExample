package com.example.myapplication.data.local.daos

import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Update

interface BaseDao<T> {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
     fun insert(entities: List<T>)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
     fun insert(entity: T)

    @Update(onConflict = OnConflictStrategy.REPLACE)
     fun update(entities: List<T>)

    @Update(onConflict = OnConflictStrategy.REPLACE)
     fun update(entity: T)

    @Delete
     fun delete(entities: List<T>)

    @Delete
     fun delete(entity: T)
}