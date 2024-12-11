package com.example.emc_redi_delivery.ui.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.util.lerp
import com.example.emc_redi_delivery.data.states.UiState
import com.example.emc_redi_delivery.ui.components.ButtonBar
import com.example.emc_redi_delivery.ui.components.SliderText
import com.example.emc_redi_delivery.ui.theme.MainBlue
import com.example.emc_redi_delivery.viewmodel.MainViewModel
import com.google.accompanist.pager.ExperimentalPagerApi
import com.google.accompanist.pager.HorizontalPager
import com.google.accompanist.pager.HorizontalPagerIndicator
import com.google.accompanist.pager.calculateCurrentOffsetForPage
import kotlinx.coroutines.launch
import kotlin.math.absoluteValue

@OptIn(ExperimentalPagerApi::class)
@Composable
fun MainScreen(viewModel: MainViewModel) {

    val uiState: UiState by viewModel.uiState.observeAsState(initial = UiState.Loading)

    val cardsData by viewModel.cardsData.observeAsState(initial = emptyList())

    val coroutineScope = rememberCoroutineScope()



    if (uiState is UiState.Loading) {
        viewModel.loadData()
        LoadingScreen(uiState)
    }
    if (uiState is UiState.Success) {
        val pagerState = com.google.accompanist.pager.rememberPagerState(initialPage = 0)

        Column(
            modifier = Modifier
                .padding(
                    top = 200.dp,
                    start = 16.dp,
                    end = 16.dp
                )
        ) {

            HorizontalPager(
                count = 3,
                state = pagerState,
                contentPadding = PaddingValues(horizontal = 16.dp),
                modifier = Modifier
                    .height(346.dp)
                    .fillMaxWidth()
            ) { page ->
                Card(
                    shape = RoundedCornerShape(12.dp),
                    modifier = Modifier
                        .graphicsLayer {
                            val pageOffset = calculateCurrentOffsetForPage(page).absoluteValue

                            lerp(
                                start = 0.85f,
                                stop = 1f,
                                fraction = 1f - pageOffset.coerceIn(0f, 1f)
                            ).also { scale ->
                                scaleX = scale
                                scaleY = scale
                            }

                            alpha = lerp(
                                start = 0.5f,
                                stop = 1f,
                                fraction = 1f - pageOffset.coerceIn(0f, 1f)
                            )
                        }
                ) {
                    Image(
                        painter = painterResource(id = cardsData[page].resource),
                        contentDescription = cardsData[page].title,
                        contentScale = ContentScale.Crop,
                        modifier = Modifier.fillMaxSize()
                    )
                }
            }
            HorizontalPagerIndicator(
                pagerState = pagerState,
                modifier = Modifier
                    .align(Alignment.CenterHorizontally)
                    .padding(16.dp),
                activeColor = MainBlue,
                inactiveColor = Color.LightGray
            )

            SliderText(
                cardsData[pagerState.currentPage].title,
            )



            if (pagerState.currentPage != 2) {
                ButtonBar(
                    onNext = {
                        coroutineScope.launch {
                            pagerState.animateScrollToPage(pagerState.currentPage + 1)
                        }
                    },
                    onSkip = {
                        coroutineScope.launch {
                            pagerState.animateScrollToPage(3)
                        }
                    }
                )
            } else {
                Column() {
                    Button(
                        onClick = {
                            viewModel.showToast("Вы не просили это делать!")
                        },
                        colors = androidx.compose.material.ButtonDefaults.buttonColors(
                            backgroundColor = MainBlue
                        ),
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(
                                top = 200.dp,
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
                                    viewModel.showToast("Вы не просили это делать!")
                                }
                        )
                    }
                }
            }
        }
    }
}