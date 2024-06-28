package com.example.geolocalisation.ui.screens

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.geolocalisation.network.ReceivedDataApi
import com.example.geolocalisation.network.ReceivedData
import kotlinx.coroutines.launch
import java.io.IOException

sealed interface ReceivedDataUiState {
    data class Success(val photos: String) : ReceivedDataUiState
    object Error : ReceivedDataUiState
    object Loading : ReceivedDataUiState

}

class ReceivedDataViewModel : ViewModel() {
    /** The mutable State that stores the status of the most recent request */
    var receivedDataUiState: ReceivedDataUiState by mutableStateOf(ReceivedDataUiState.Loading) //loading is defined as the default marUiState value
        private set


    /**
     * Call getData() on init so we can display status immediately.
     */
    init {
        getData()
    }

    /**
     * Gets data from the Retrofit service and updates the
     * [ReceivedData] [List] [MutableList].
     */
    private fun getData() {
        viewModelScope.launch {
             try { //represents the state of the most recent web request
                 val listResult = ReceivedDataApi.retrofitService.getJson() //saves the received response from the backend server in a val called listResult
                 receivedDataUiState = ReceivedDataUiState.Success(
                    "Success: ${listResult.size} data retrieved \n" +
                            listResult
                )
            } catch (e: IOException) {
                 receivedDataUiState = ReceivedDataUiState.Error
            }
        }
    }
}
