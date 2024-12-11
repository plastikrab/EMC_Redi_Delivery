package com.example.emc_redi_delivery

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.emc_redi_delivery.ui.screens.MainScreen
import com.example.emc_redi_delivery.ui.theme.EMC_Redi_DeliveryTheme
import com.example.emc_redi_delivery.viewmodel.MainViewModel

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val mainViewModel = MainViewModel(this)

        enableEdgeToEdge()
        setContent {
            EMC_Redi_DeliveryTheme {
                MainScreen(mainViewModel)
            }
        }
    }
}

