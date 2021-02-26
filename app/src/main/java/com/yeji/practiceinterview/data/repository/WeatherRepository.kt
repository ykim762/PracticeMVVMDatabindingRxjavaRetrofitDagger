package com.yeji.practiceinterview.data.repository

import com.yeji.practiceinterview.data.model.WeatherResponse
import com.yeji.practiceinterview.app.Config
import com.yeji.practiceinterview.data.network.MyApi
import com.yeji.practiceinterview.di.AppModule
import com.yeji.practiceinterview.di.DaggerAppComponent
import io.reactivex.Single
import javax.inject.Inject

class WeatherRepository {

    @Inject
    lateinit var api:MyApi

    fun getWeather(lat:Double, lon:Double): Single<WeatherResponse> {
        var appComponent= DaggerAppComponent.builder().appModule(AppModule()).build()
        appComponent.inject(this)

        return api.getWeatherThisLoc(lat, lon, Config.EXCLUDE, Config.API_KEY)
    }
}