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

    private val _sportsData = MutableLiveData<List<Sport>>()  // LiveData for sports data
    val sportsData: LiveData<List<Sport>> get() = _sportsData  // Exposed LiveData

    private val _errorMessage = MutableLiveData<String>()  // LiveData for error messages
    val errorMessage: LiveData<String> get() = _errorMessage  // Exposed LiveData

    fun fetchSportsData() {
        // Make a network call to fetch sports data
        RetrofitInstance.api.getSports().enqueue(object : Callback<SportsResponse> {
            override fun onResponse(call: Call<SportsResponse>, response: Response<SportsResponse>) {
                if (response.isSuccessful) {
                    val sportsList = response.body()?.entities  // Get the list of sports from the response
                    _sportsData.postValue(sportsList ?: emptyList())  // Post the list or an empty list if null
                } else {
                    _errorMessage.postValue("Failed to retrieve data")  // Post error message for unsuccessful response
                }
            }

            override fun onFailure(call: Call<SportsResponse>, t: Throwable) {
                _errorMessage.postValue("Network Error: ${t.message}")  // Post error message for network failure
            }
        })
    }
}
