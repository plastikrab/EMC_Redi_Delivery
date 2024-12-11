package com.example.emc_redi_delivery.ui.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.emc_redi_delivery.R
import com.example.emc_redi_delivery.data.states.UiState


@Composable
fun LoadingScreen(
    uiState: UiState
) {

    Box(
        modifier = Modifier
            .fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Image(
                painter = painterResource(id = R.drawable.logo_image),
                contentDescription = null,
                modifier = Modifier
                    .size(width = 215.dp, height = 78.dp)
            )
            if (uiState is UiState.Loading){
                CircularProgressIndicator(
                    modifier = Modifier
                        .padding(50.dp)
                )
            }
        }
    }

}