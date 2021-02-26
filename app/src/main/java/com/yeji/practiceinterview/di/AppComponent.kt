package com.yeji.practiceinterview.di

import com.yeji.practiceinterview.data.repository.WeatherRepository
import dagger.Component

@Component(modules = [AppModule::class])
interface AppComponent {
    fun inject(weatherRepository: WeatherRepository)
}