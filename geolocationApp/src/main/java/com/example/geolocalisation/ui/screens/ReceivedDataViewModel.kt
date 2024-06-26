/*
 * Copyright (C) 2023 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
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
     * Call getMarsPhotos() on init so we can display status immediately.
     */
    init {
        getData()
    }

    /**
     * Gets Mars photos information from the Mars API Retrofit service and updates the
     * [ReceivedData] [List] [MutableList].
     */
    private fun getData() {
        viewModelScope.launch {
             try { //represents the state of the most recent web request
                 val listResult = ReceivedDataApi.retrofitService.getPhotos() //saves the received response from the backend server in a val called listResult
                 receivedDataUiState = ReceivedDataUiState.Success(
                    "Success: ${listResult.size} Mars photos retrieved"
                )
            } catch (e: IOException) {
                 receivedDataUiState = ReceivedDataUiState.Error
            }
        }
    }
}
