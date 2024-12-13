package com.example.emc_redi_delivery.ui.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.example.emc_redi_delivery.ui.theme.MainBlue

@Composable
fun SignInButton(
    modifier: Modifier = Modifier,
    onClick: () -> Unit,
){

    Column(
        modifier = modifier,
    ) {
        Button(
            onClick = {
                onClick()
            },
            colors = androidx.compose.material.ButtonDefaults.buttonColors(
                backgroundColor = MainBlue
            ),
            modifier = Modifier
                .fillMaxWidth()
                .padding(
                    start = 16.dp,
                    end = 16.dp,
                    bottom = 6.dp
                )
                .height(46.dp)
        ) {
            Text(
                text = "Sign Up",
                color = Color.White,
                fontWeight = FontWeight(850),
            )
        }
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(
                    start = 16.dp,
                    end = 16.dp
                ),
            horizontalArrangement = Arrangement.Center
        ) {
            Text(
                text = "Already have an account?",
                color = Color.Gray,
                fontWeight = FontWeight(450),
                modifier = Modifier

            )
            Text(
                text = "Sign in",
                color = MainBlue,
                fontWeight = FontWeight(850),
                modifier = Modifier
                    .clickable {
                        onClick()
                    }
            )
        }
    }
}