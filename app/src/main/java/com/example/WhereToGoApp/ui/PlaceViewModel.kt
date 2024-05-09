package com.example.WhereToGoApp.ui

import androidx.lifecycle.ViewModel
import com.example.WhereToGoApp.data.PlaceUiState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update

class PlaceViewModel : ViewModel() {

    private val _uiState = MutableStateFlow(PlaceUiState())
    val uiState: StateFlow<PlaceUiState> = _uiState.asStateFlow()

    fun setQuantity(numberCupcakes: Int) {
        _uiState.update { currentState ->
            currentState.copy(
                placeNumber = numberCupcakes,
            )
        }
    }

}