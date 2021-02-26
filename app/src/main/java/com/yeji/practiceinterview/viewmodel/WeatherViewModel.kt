package com.yeji.practiceinterview.viewmodel

import com.yeji.practiceinterview.data.model.WeatherResponse
import androidx.lifecycle.ViewModel
import com.yeji.practiceinterview.data.repository.WeatherRepository
import io.reactivex.Single

class WeatherViewModel :ViewModel(){

    lateinit var weatherRepository: WeatherRepository

    fun curLocWeather(lat:Double, lon:Double):Single<WeatherResponse>{
        weatherRepository = WeatherRepository()
        return weatherRepository.getWeather(lat, lon)
    }
}