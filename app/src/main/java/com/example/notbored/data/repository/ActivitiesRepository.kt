package com.example.notbored.data.repository

import com.example.notbored.data.model.Activities
import com.example.notbored.data.model.ResponseActivity
import com.example.notbored.data.service.APIServiceActivity
import retrofit2.Response
import javax.inject.Inject

class ActivitiesRepository @Inject constructor(val apiService: APIServiceActivity){

    private val activities= Activities()

    fun getTypeActivities(): List<String> {
        return activities.listActivities
    }
    suspend fun getActivity(type:String, participants: String): Response<ResponseActivity> {
       return apiService.getActivity(type,participants)
    }
}