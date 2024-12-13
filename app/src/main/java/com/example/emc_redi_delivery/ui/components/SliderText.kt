package com.example.emc_redi_delivery.ui.components

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.sp
import com.example.emc_redi_delivery.ui.theme.MainBlue


@Composable
fun SliderText(
    modifier: Modifier = Modifier,
    text: String
){
    Text(
        text = text,
        fontWeight = FontWeight(850),
        maxLines = 2,
        color = MainBlue,
        fontSize = 30.sp,
        modifier = modifier,
        textAlign = TextAlign.Center
    )
}