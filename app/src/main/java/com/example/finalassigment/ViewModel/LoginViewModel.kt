package com.example.finalassigment

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import okhttp3.Call
import okhttp3.Callback
import okhttp3.MediaType.Companion.toMediaType
import okhttp3.OkHttpClient
import okhttp3.Request
import okhttp3.RequestBody.Companion.toRequestBody
import okhttp3.Response
import org.json.JSONObject
import java.io.IOException

class LoginViewModel : ViewModel() {
    private val client = OkHttpClient()  // OkHttpClient instance for network calls

    private val _loginResult = MutableLiveData<Boolean>()  // LiveData for login success status
    val loginResult: LiveData<Boolean> get() = _loginResult  // Exposed LiveData

    private val _errorMessage = MutableLiveData<String>()  // LiveData for error messages
    val errorMessage: LiveData<String> get() = _errorMessage  // Exposed LiveData

    fun login(username: String, password: String) {
        val url = "https://nit3213-api-h2b3-latest.onrender.com/footscray/auth"  // API endpoint for login

        val jsonObject = JSONObject().apply {
            put("username", username)  // Add username to JSON object
            put("password", password)  // Add password to JSON object
        }

        val requestBody = jsonObject.toString().toRequestBody("application/json".toMediaType())  // Create request body

        val request = Request.Builder()
            .url(url)  // Set the URL
            .post(requestBody)  // Set the request method to POST with the request body
            .build()  // Build the request

        client.newCall(request).enqueue(object : Callback {
            override fun onFailure(call: Call, e: IOException) {
                _errorMessage.postValue("Network Error")  // Post network error message
            }

            override fun onResponse(call: Call, response: Response) {
                if (response.isSuccessful) {
                    _loginResult.postValue(true)  // Post success status
                } else {
                    _loginResult.postValue(false)  // Post failure status
                    _errorMessage.postValue("Invalid Credentials")  // Post error message for invalid credentials
                }
            }
        })
    }
}
