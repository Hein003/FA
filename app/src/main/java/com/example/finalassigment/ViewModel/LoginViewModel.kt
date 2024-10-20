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
    private val client = OkHttpClient()

    private val _loginResult = MutableLiveData<Boolean>()
    val loginResult: LiveData<Boolean> get() = _loginResult

    private val _errorMessage = MutableLiveData<String>()
    val errorMessage: LiveData<String> get() = _errorMessage

    fun login(username: String, password: String) {
        val url = "https://nit3213-api-h2b3-latest.onrender.com/footscray/auth"

        val jsonObject = JSONObject()
        jsonObject.put("username", username)
        jsonObject.put("password", password)

        val requestBody = jsonObject.toString().toRequestBody("application/json".toMediaType())

        val request = Request.Builder()
            .url(url)
            .post(requestBody)
            .build()

        client.newCall(request).enqueue(object : Callback {
            override fun onFailure(call: Call, e: IOException) {
                _errorMessage.postValue("Network Error")
            }

            override fun onResponse(call: Call, response: Response) {
                if (response.isSuccessful) {
                    _loginResult.postValue(true)
                } else {
                    _loginResult.postValue(false)
                    _errorMessage.postValue("Invalid Credentials")
                }
            }
        })
    }
}
