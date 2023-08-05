package com.example.myapplication.data.local.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.myapplication.data.remote.dtos.IntervalDto
import com.example.myapplication.data.remote.dtos.TimeLineDto
import com.example.myapplication.data.remote.dtos.ValueDto

@Entity(tableName = "time_line")
data class TimeLineEntity(
    @ColumnInfo(name = "timestep") val timestep: String,
    @ColumnInfo(name = "startTime") val startTime: String,
    @ColumnInfo(name = "endTime") val endTime: String,
    @ColumnInfo(name = "intervals") val intervals: List<IntervalEntity>,
) {
    @PrimaryKey(autoGenerate = true) @ColumnInfo(name = "id") var id: Long = 0
    constructor(
        timeLineDto: TimeLineDto,
    ) : this(
        timestep = timeLineDto.timestep,
        startTime = timeLineDto.startTime,
        endTime = timeLineDto.endTime,
        intervals = timeLineDto.intervals.map {
            IntervalEntity(it) }
    )
}

@Entity(tableName = "interval")
data class IntervalEntity(
    @ColumnInfo(name = "startTime") val startTime: String,
    @ColumnInfo(name = "values") val values: ValueEntity?,
) {
    @PrimaryKey(autoGenerate = true) @ColumnInfo(name = "id") var id: Long =0
    constructor(
        intervalDto: IntervalDto,
    ) : this(
        startTime = intervalDto.startTime,
        values = intervalDto.values,
    )
}

@Entity(tableName = "weather_value")
data class ValueEntity(
    @ColumnInfo(name ="precipitationIntensity") val precipitationIntensity: Double?,
    @ColumnInfo(name ="precipitationType") val precipitationType: Double?,
    @ColumnInfo(name ="windSpeed") val windSpeed: Double?,
    @ColumnInfo(name ="windGust") val windGust: Double?,
    @ColumnInfo(name ="windDirection") val windDirection: Double?,
    @ColumnInfo(name ="temperature") val temperature: Double?,
    @ColumnInfo(name ="temperatureApparent") val temperatureApparent: Double?,
    @ColumnInfo(name ="cloudCover") val cloudCover: Double?,
    @ColumnInfo(name ="cloudBase") val cloudBase: Double?,
    @ColumnInfo(name ="cloudCeiling") val cloudCeiling: Double?,
    @ColumnInfo(name ="weatherCode") val weatherCode: Double?
) {
    @PrimaryKey(autoGenerate = true) @ColumnInfo(name = "id") var id: Long =0
    constructor(
        valueEntity: ValueDto,
    ) : this (

        precipitationIntensity = valueEntity.precipitationIntensity,
        precipitationType= valueEntity.precipitationType,
        windSpeed = valueEntity.windSpeed,
        windGust= valueEntity.windGust,
        windDirection= valueEntity.windDirection,
        temperature = valueEntity.temperature,
        temperatureApparent= valueEntity.temperatureApparent,
        cloudCover= valueEntity.cloudCover,
        cloudBase= valueEntity.cloudBase,
        cloudCeiling= valueEntity.cloudCeiling,
        weatherCode= valueEntity.weatherCode,
    )
}