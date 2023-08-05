package com.example.myapplication.core

import androidx.recyclerview.widget.DiffUtil
import com.example.myapplication.ui.WeatherValueeUiHolder

object Constants {
    const val BASE_URL =  "http://10.0.2.2/"
    const val DATABASE_NAME = "weather.db"
}

object WeatherValueDiffCallBack : DiffUtil.ItemCallback<WeatherValueeUiHolder>() {
    override fun areItemsTheSame(
        oldItem: WeatherValueeUiHolder,
        newItem: WeatherValueeUiHolder
    ): Boolean {
        return newItem.id == oldItem.id

    }
    override fun areContentsTheSame(
        oldItem: WeatherValueeUiHolder,
        newItem: WeatherValueeUiHolder
    ): Boolean {
        return newItem == oldItem
    }
}