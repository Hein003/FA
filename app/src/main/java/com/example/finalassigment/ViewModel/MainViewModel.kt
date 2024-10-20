package com.example.finalassigment

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.finalassigment.data.Sport
import com.example.finalassigment.data.SportsResponse
import com.example.finalassigment.network.RetrofitInstance
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainViewModel : ViewModel() {

    private val _sportsData = MutableLiveData<List<Sport>>() // Changed from SportsResponse.Entity to Sport
    val sportsData: LiveData<List<Sport>> get() = _sportsData

    private val _errorMessage = MutableLiveData<String>()
    val errorMessage: LiveData<String> get() = _errorMessage

    fun fetchSportsData() {
        RetrofitInstance.api.getSports().enqueue(object : Callback<SportsResponse> {
            override fun onResponse(call: Call<SportsResponse>, response: Response<SportsResponse>) {
                if (response.isSuccessful) {
                    val sportsList = response.body()?.entities
                    _sportsData.postValue(sportsList ?: emptyList())
                } else {
                    _errorMessage.postValue("Failed to retrieve data")
                }
            }

            override fun onFailure(call: Call<SportsResponse>, t: Throwable) {
                _errorMessage.postValue("Network Error: ${t.message}")
            }
        })
    }
}
