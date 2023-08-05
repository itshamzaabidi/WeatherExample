package com.example.myapplication.data.remote.dtos


import com.example.myapplication.data.local.entities.ValueEntity
import com.google.gson.annotations.SerializedName

data class TimeLineDto(
    @SerializedName("timestep") val timestep: String,
    @SerializedName("startTime") val startTime: String,
    @SerializedName("endTime") val endTime: String,
    @SerializedName("intervals") val intervals: MutableList<IntervalDto>,
)

data class IntervalDto(
    @SerializedName("startTime") val startTime: String,
    @SerializedName("values") val values: ValueEntity,
)

data class ValueDto(
    @SerializedName("precipitationIntensity") val precipitationIntensity: Double?,
    @SerializedName("precipitationType") val precipitationType: Double?,
    @SerializedName("windSpeed") val windSpeed: Double?,
    @SerializedName("windGust") val windGust: Double?,
    @SerializedName("windDirection") val windDirection: Double?,
    @SerializedName("temperature") val temperature: Double?,
    @SerializedName("temperatureApparent") val temperatureApparent: Double?,
    @SerializedName("cloudCover") val cloudCover: Double?,
    @SerializedName("cloudBase") val cloudBase: Double?,
    @SerializedName("cloudCeiling") val cloudCeiling: Double?,
    @SerializedName("weatherCode") val weatherCode: Double?
)


