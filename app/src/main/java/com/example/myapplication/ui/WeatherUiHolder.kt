package com.example.myapplication.ui

import com.example.myapplication.data.local.entities.ValueEntity

data class WeatherValueeUiHolder(
    var id: Long,
    var windSpeed: Double?,
    var temperature: Double?,
    var temperatureApparent: Double?,
) {

    constructor(entity: ValueEntity) : this(
        id = entity.id,
        windSpeed = entity.windSpeed,
        temperature = entity.temperature,
        temperatureApparent = entity.temperatureApparent
    )
}