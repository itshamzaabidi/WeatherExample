package com.example.myapplication.data.local.entities

import androidx.room.ProvidedTypeConverter
import androidx.room.TypeConverter
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

@ProvidedTypeConverter
class Converters {
    @TypeConverter
    fun stringToTimeLines(string: String?): List<TimeLineEntity>? {
        val listType = object : TypeToken<List<TimeLineEntity>>() {}.type
        return Gson().fromJson(string, listType)
    }

    @TypeConverter
    fun timeLinesToString(list: List<TimeLineEntity>?): String? {
        val gson = Gson()
        return gson.toJson(list)
    }
    @TypeConverter
    fun stringToIntervals(string: String?): List<IntervalEntity>? {
        val listType = object : TypeToken<List<IntervalEntity>>() {}.type
        return Gson().fromJson(string, listType)
    }

    @TypeConverter
    fun intervalsToString(list: List<IntervalEntity>?): String? {
        val gson = Gson()
        return gson.toJson(list)
    }
    @TypeConverter
    fun stringToValue(string: String?): ValueEntity? {
        val listType = object : TypeToken<ValueEntity>() {}.type
        return Gson().fromJson(string, listType)
    }

    @TypeConverter
    fun valueToString(list: ValueEntity?): String? {
        val gson = Gson()
        return gson.toJson(list)
    }


}