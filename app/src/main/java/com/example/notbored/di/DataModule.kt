package com.example.notbored.di

import com.example.notbored.data.repository.ActivitiesRepository
import com.example.notbored.data.service.APIServiceActivity
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class DataModule {

    @Singleton
    @Provides
    fun provideRetrofit():Retrofit{
        return Retrofit.Builder()
            .baseUrl("http://www.boredapi.com/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }
    @Singleton
    @Provides
    fun provideApiService(retrofit: Retrofit): APIServiceActivity {
        return retrofit.create(APIServiceActivity::class.java)
    }
    @Singleton
    @Provides
    fun provideActivitiesRepository(apiService:APIServiceActivity): ActivitiesRepository {
        return ActivitiesRepository(apiService)
    }
}