package com.example.myapplication

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.myapplication.data.repositories.TimeLineRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val timeLineRepository: TimeLineRepository,

) : ViewModel() {



    fun refreshWeather() {

        viewModelScope.launch {
              timeLineRepository.refreshTimeLine()
        }
    }


}