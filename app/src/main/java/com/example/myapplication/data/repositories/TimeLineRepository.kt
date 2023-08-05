package com.example.myapplication.data.repositories

import android.util.Log
import com.bumptech.glide.load.engine.Resource
import com.example.myapplication.data.local.AppDatabase
import com.example.myapplication.data.local.entities.TimeLineEntity
import com.example.myapplication.data.remote.CustomApi
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import java.lang.Exception
import javax.inject.Inject

interface TimeLineRepository {

    fun refreshTimeLine(): Flow<Resource<Boolean>>

    fun finAll(): List<TimeLineEntity?>

    fun findOne(timeLineId: Long): TimeLineEntity?

}


class TimeLineRepositoryImpl @Inject constructor(
    private val appDatabase: AppDatabase,
    private val customApi: CustomApi,
) : TimeLineRepository {
    override fun finAll(): List<TimeLineEntity?> {
        return appDatabase.timeLineDao().findAll()
    }

    override fun findOne(timeLineId: Long): TimeLineEntity? {
        return appDatabase.timeLineDao().findOne(timeLineId)
    }

    override fun refreshTimeLine(): Flow<Resource<Boolean>> = flow {
       // emit(Resource.Loading())

        try {
            val timeLineResponse = customApi.refreshWeather()
            if (timeLineResponse.isSuccessful) {
                Log.i("refreshTimeLine", "data: "+timeLineResponse.body())
            }else{
                Log.i("refreshTimeLine", "unSuccessful:"+timeLineResponse.code())
            }
        }catch (e:Exception){
            Log.e("refreshTimeLine", "refreshTimeLine: "+e.message )
        }

    }

}



