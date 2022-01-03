package com.example.notbored.ui.viewModel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.notbored.data.model.ResponseActivity
import com.example.notbored.data.repository.ActivitiesRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ActivitiesViewModel @Inject constructor(val activitiesRepository: ActivitiesRepository): ViewModel() {

    val liveListActivities = MutableLiveData<List<String>>()
    val liveResponseActivity= MutableLiveData<ResponseActivity>()

    fun setLiveActivities(){
        liveListActivities.postValue(activitiesRepository.getTypeActivities())
    }

    fun getActivities(type:String, participants:String){
        CoroutineScope(Dispatchers.IO).launch {
            val call = activitiesRepository.getActivity(type, participants)
            if(call.isSuccessful){
                liveResponseActivity.postValue(call.body())
            }
        }
    }
}