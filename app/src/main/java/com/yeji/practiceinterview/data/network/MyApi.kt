package com.yeji.practiceinterview.data.network

import com.jakewharton.retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import com.yeji.practiceinterview.app.Config
import com.yeji.practiceinterview.data.model.WeatherResponse
import io.reactivex.Single
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Query

interface MyApi {

    @GET("onecall")
    fun getWeatherThisLoc(
        @Query("lat") lat: Double,
        @Query("lon") lon: Double,
        @Query("exclude") exclude: String,
        @Query("appid") key: String
    ): Single<WeatherResponse>

    companion object {
        operator fun invoke(): MyApi = Retrofit.Builder()
            .baseUrl(Config.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .build()
            .create(MyApi::class.java)
    }
}