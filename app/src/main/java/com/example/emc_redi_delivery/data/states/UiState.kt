package com.example.emc_redi_delivery.data.states


sealed class UiState {
    object Initial : UiState()
    object Loading : UiState()
    data class Success(val data: List<String>?) : UiState()
    data class Error(val message: String) : UiState()
}