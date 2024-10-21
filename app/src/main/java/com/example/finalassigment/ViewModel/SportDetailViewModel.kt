package com.example.finalassigment

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class SportDetailViewModel : ViewModel() {

    private val _sportName = MutableLiveData<String>()  // LiveData for sport name
    val sportName: LiveData<String> get() = _sportName  // Exposed LiveData

    private val _playerCount = MutableLiveData<Int>()  // LiveData for player count
    val playerCount: LiveData<Int> get() = _playerCount  // Exposed LiveData

    private val _fieldType = MutableLiveData<String>()  // LiveData for field type
    val fieldType: LiveData<String> get() = _fieldType  // Exposed LiveData

    private val _olympicSport = MutableLiveData<Boolean>()  // LiveData for Olympic status
    val olympicSport: LiveData<Boolean> get() = _olympicSport  // Exposed LiveData

    private val _description = MutableLiveData<String>()  // LiveData for sport description
    val description: LiveData<String> get() = _description  // Exposed LiveData

    // Function to set sport details
    fun setSportDetails(
        sportName: String,
        playerCount: Int,
        fieldType: String,
        olympicSport: Boolean,
        description: String
    ) {
        _sportName.value = sportName  // Set sport name
        _playerCount.value = playerCount  // Set player count
        _fieldType.value = fieldType  // Set field type
        _olympicSport.value = olympicSport  // Set Olympic status
        _description.value = description  // Set sport description
    }
}
