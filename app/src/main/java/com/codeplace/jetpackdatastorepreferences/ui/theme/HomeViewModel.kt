package com.codeplace.jetpackdatastorepreferences.ui.theme


import android.content.Context
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.State
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import com.codeplace.jetpackdatastorepreferences.StateResult
import com.codeplace.jetpackdatastorepreferences.data.DataStoreRepository
import com.codeplace.jetpackdatastorepreferences.model.UserPreferences
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.update

class HomeViewModel(
    private val dataStoreRepository: DataStoreRepository
):ViewModel() {


    // StateFlow :
    private val _isFirstUserAccess = MutableStateFlow(true)
    val isFirstUserAccess = _isFirstUserAccess.asStateFlow()


    suspend fun saveAppEntry(){
        dataStoreRepository.saveAppEntry()
    }

    suspend fun readState(){
        dataStoreRepository.readAppEntry().collect{ userPreference ->
            _isFirstUserAccess.value = userPreference.isFirstUserAccess
        }
    }
}

