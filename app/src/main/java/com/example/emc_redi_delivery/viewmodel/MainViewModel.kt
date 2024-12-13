package com.example.emc_redi_delivery.viewmodel

import android.content.Context
import android.widget.Toast
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.emc_redi_delivery.R
import com.example.emc_redi_delivery.data.entytyes.SliderItem
import com.example.emc_redi_delivery.data.states.UiState
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch


class MainViewModel(
    private val context: Context
) : ViewModel() {

    //UI State
    private val _uiState = MutableLiveData<UiState>(UiState.Loading)
    val uiState: LiveData<UiState> get() = _uiState

    //Cards data
    private val _cardsData = MutableLiveData<List<SliderItem>>()
    val cardsData: LiveData<List<SliderItem>> get() = _cardsData

    fun loadData() {
        _uiState.value = UiState.Loading
        viewModelScope.launch {
            delay(1)
            _cardsData.value = listOf(
                SliderItem(
                    title = "Enjoy quick pick-up and delivery to your destination",
                    resource = R.drawable.image_1
                ),
                SliderItem(
                    title = "Flexible Payment",
                    resource = R.drawable.image_2
                ),
                SliderItem(
                    title = "Real-time Tracking",
                    resource = R.drawable.image_3
                ),

                )
            _uiState.value = UiState.Success(null)
        }
    }

    fun showToast(text: String) {
        val toast = Toast.makeText(
            context,
            text,
            Toast.LENGTH_LONG
        )
        toast.show()
    }
}

