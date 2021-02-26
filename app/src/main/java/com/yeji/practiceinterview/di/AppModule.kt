package com.yeji.practiceinterview.di

import com.yeji.practiceinterview.data.network.MyApi
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class AppModule {

//    @Singleton
    @Provides
    fun providesApi():MyApi{
        return MyApi()
    }
}