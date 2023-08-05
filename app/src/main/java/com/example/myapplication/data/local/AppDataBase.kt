package com.example.myapplication.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.example.myapplication.data.local.daos.IntervalDao
import com.example.myapplication.data.local.daos.TimeLineDao
import com.example.myapplication.data.local.daos.ValueDao
import com.example.myapplication.data.local.entities.Converters
import com.example.myapplication.data.local.entities.IntervalEntity
import com.example.myapplication.data.local.entities.TimeLineEntity
import com.example.myapplication.data.local.entities.ValueEntity


@Database(
        entities = [
            TimeLineEntity::class,
            IntervalEntity::class,
            ValueEntity::class
        ],
        version = 1,
        exportSchema = false
    )
    @TypeConverters(Converters::class)
    abstract class AppDatabase : RoomDatabase() {
        abstract fun timeLineDao(): TimeLineDao
        abstract fun intervalDao(): IntervalDao
        abstract fun valueDao(): ValueDao
    }