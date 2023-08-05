package com.example.myapplication.data.repositories

import android.util.Log
import com.bumptech.glide.load.engine.Resource
import com.example.myapplication.data.local.AppDatabase
import com.example.myapplication.data.local.entities.TimeLineEntity
import com.example.myapplication.data.remote.CustomApi
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.lang.Exception
import java.net.ConnectException
import javax.inject.Inject
import kotlin.math.log

interface TimeLineRepository {

    fun refreshTimeLine(): Flow<Resource<Boolean>>

    fun finAll(): List<TimeLineEntity>

    fun findOne(timeLineId: Long): TimeLineEntity

}


class TimeLineRepositoryImpl @Inject constructor(
    private val appDatabase: AppDatabase,
    private val customApi: CustomApi,
) : TimeLineRepository {
    override fun finAll(): List<TimeLineEntity> {
        TODO("Not yet implemented")
    }

    override fun findOne(timeLineId: Long): TimeLineEntity {
        TODO("Not yet implemented")
    }

    override fun refreshTimeLine(): Flow<Resource<Boolean>> = flow {
       // emit(Resource.Loading())

        try {
            val timeLineResponse = customApi.refreshWeather()
            if (timeLineResponse.isSuccessful) {
                Log.i("TAG", "data: "+timeLineResponse.body())
            }
        }catch (e:Exception){
            Log.e("TAG", "refreshTimeLine: "+e.message )
        }

    }

}



