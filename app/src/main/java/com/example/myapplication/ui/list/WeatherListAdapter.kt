package com.example.myapplication.ui.list

import android.view.LayoutInflater

import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication.R
import com.example.myapplication.core.ItemClick
import com.example.myapplication.core.WeatherValueDiffCallBack
import com.example.myapplication.databinding.ListItemBinding
import com.example.myapplication.ui.WeatherValueeUiHolder

class WeatherListAdapter (
    private val listener: ItemClick<WeatherValueeUiHolder>,
) :  ListAdapter<WeatherValueeUiHolder, WeatherListAdapter.ViewHolder>(
    WeatherValueDiffCallBack
) {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): WeatherListAdapter.ViewHolder {
        return ViewHolder(
            DataBindingUtil.inflate(
                LayoutInflater.from(parent.context),
                R.layout.list_item,
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: WeatherListAdapter.ViewHolder, position: Int) {
        getItem(position)?.let {
            holder.bindTo(it)
        }
    }

    inner class ViewHolder(private val binding: ListItemBinding) :
        RecyclerView.ViewHolder(binding.root){

        fun bindTo(weatherValueeUiHolder: WeatherValueeUiHolder) {
            binding.txtAirSpeedValue.text = weatherValueeUiHolder.windSpeed.toString()
            binding.txtTemperatureValue.text = weatherValueeUiHolder.temperature.toString()
            binding.txtTemperatureApparent.text = weatherValueeUiHolder.temperatureApparent.toString()

        }



    }

}