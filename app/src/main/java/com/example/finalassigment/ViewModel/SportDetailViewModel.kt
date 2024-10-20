package com.example.finalassigment

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class SportDetailViewModel : ViewModel() {

    private val _sportName = MutableLiveData<String>()
    val sportName: LiveData<String> get() = _sportName

    private val _playerCount = MutableLiveData<Int>()
    val playerCount: LiveData<Int> get() = _playerCount

    private val _fieldType = MutableLiveData<String>()
    val fieldType: LiveData<String> get() = _fieldType

    private val _olympicSport = MutableLiveData<Boolean>()
    val olympicSport: LiveData<Boolean> get() = _olympicSport

    private val _description = MutableLiveData<String>()
    val description: LiveData<String> get() = _description

    // Function to set the data, which would typically be passed from the Intent
    fun setSportDetails(
        sportName: String,
        playerCount: Int,
        fieldType: String,
        olympicSport: Boolean,
        description: String
    ) {
        _sportName.value = sportName
        _playerCount.value = playerCount
        _fieldType.value = fieldType
        _olympicSport.value = olympicSport
        _description.value = description
    }
}
