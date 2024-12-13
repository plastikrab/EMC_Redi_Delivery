package com.example.emc_redi_delivery.ui.components

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.emc_redi_delivery.ui.theme.MainBlue

@Composable
fun ButtonBar(
    modifier: Modifier = Modifier,
    onNext: () -> Unit,
    onSkip: () -> Unit
){
    Row(
        modifier = modifier,
        horizontalArrangement = Arrangement.SpaceBetween

    ) {
        OutlinedButton (
            onClick = onSkip,
            border = BorderStroke(
                color = MainBlue,
                width = 1.dp
            )
        ){
            Text(
                text = "Skip",
                color = MainBlue
            )
        }
        Button(
            onClick = onNext,
            colors = ButtonDefaults.buttonColors(
                backgroundColor = MainBlue
            )
        ){
            Text(
                text = "Next",
                color = Color.White
            )
        }
    }
}

@Preview
@Composable
fun ButtonBarPreview(){
    ButtonBar(
        onNext = {},
        onSkip = {}
    )
}