package com.example.myapplication.data.di

import android.annotation.SuppressLint
import android.content.Context
import androidx.room.Room
import com.example.myapplication.core.Constants.BASE_URL
import com.example.myapplication.core.Constants.DATABASE_NAME
import com.example.myapplication.data.local.AppDatabase
import com.example.myapplication.data.local.entities.Converters
import com.example.myapplication.data.remote.CustomApi
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.SupervisorJob
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import org.apache.http.conn.ssl.AllowAllHostnameVerifier
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit
import javax.inject.Singleton


    @Module
    @InstallIn(SingletonComponent::class)
    class DataModule {



        @Singleton
        @Provides
        fun provideInterceptor(): Interceptor {
            val logger = HttpLoggingInterceptor(
                logger = HttpLoggingInterceptor.Logger.DEFAULT
            )
            logger.level = HttpLoggingInterceptor.Level.BODY
            return logger
        }



        @SuppressLint("AllowAllHostnameVerifier")
        @Singleton
        @Provides
        fun provideOkHttpClient(
            interceptor: Interceptor, ): OkHttpClient = OkHttpClient.Builder()
            .addInterceptor(interceptor)
            .hostnameVerifier(AllowAllHostnameVerifier())
            .readTimeout(20, TimeUnit.SECONDS)
            .build()

        @Singleton
        @Provides
        fun provideRetrofit(okHttpClient: OkHttpClient, gson: Gson): Retrofit = Retrofit.Builder()
            .baseUrl(BASE_URL)
            .client(okHttpClient)
            .addConverterFactory(GsonConverterFactory.create(gson))
            .build()

        @Singleton
        @Provides
        fun provideRadeemApi(retrofit: Retrofit): CustomApi = retrofit.create(CustomApi::class.java)


        @Singleton
        @Provides
        fun provideDatabase(
            @ApplicationContext context: Context,
        ): AppDatabase = Room.databaseBuilder(
            context,
            AppDatabase::class.java,
            DATABASE_NAME
        ).allowMainThreadQueries()
            .addTypeConverter(Converters()).build()

        @Singleton
        @Provides
        fun providesCoroutineScope(): CoroutineScope {
            return CoroutineScope(SupervisorJob() + Dispatchers.Default)
        }

        @Singleton
        @Provides
        fun provideGson(): Gson = GsonBuilder().serializeNulls().create()
    }
