package no.rindus.android.rindus.ui.forecast.components.forecast

import android.widget.Toast
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.Divider
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import no.rindus.android.rindus.R
import no.rindus.android.rindus.domain.entitiy.Forecast
import no.rindus.android.rindus.ui.forecast.UIState
import no.rindus.android.rindus.ui.theme.Blue200
import org.koin.androidx.compose.getViewModel


@Composable
fun ForecastScreen() {
    val viewModel = getViewModel<ForecastViewModel>()
    val uiState by viewModel.screenStates.collectAsState()
    Column(Modifier
        .fillMaxSize()
        .background(Blue200)) {
        when (uiState) {
            is UIState.LoadingState -> LoadingComponent()
            is UIState.ShowList -> {
                Column {
                    val listItems = (uiState as UIState.ShowList).list
                    LazyColumn(
                        Modifier
                            .background(Blue200)
                            .fillMaxSize()
                            .weight(1f),
                        contentPadding = PaddingValues(end = 10.dp, start = 10.dp),
                    ) {
                        itemsIndexed(items = listItems, itemContent = { index, value ->
                            ItemForecast(
                                item = value,
                            )
                            Divider(color = Color.White, thickness = 1.dp)
                        }
                        )
                    }
                }
            }
            UIState.ErrorState -> Toast.makeText(LocalContext.current, R.string.error, Toast.LENGTH_SHORT).show()

        }
    }
}


@Composable
fun ItemForecast(
    item: Forecast,
) {
    Column(
        Modifier
            .fillMaxWidth()
            .background(Blue200)
            .padding(
                top = 6.dp,
                bottom = 6.dp,

                )
    ) {
        Text(
            text = stringResource(id = R.string.date) + " " + item.feelsLike,
            color = Color.White,
            style = MaterialTheme.typography.caption,
            fontSize = 14.sp,
            modifier = Modifier
                .padding(10.dp)
        )
        Text(
            text = stringResource(id = R.string.temperatureMax) + " " + item.feelsLike,
            color = Color.White,
            style = MaterialTheme.typography.caption,
            fontSize = 14.sp,
            modifier = Modifier
                .padding(10.dp)
        )
        Text(
            text = stringResource(id = R.string.temperature) + item.temp,
            color = Color.White,
            style = MaterialTheme.typography.caption,
            fontSize = 14.sp,
            modifier = Modifier
                .padding(10.dp)
        )
        Text(
            text = stringResource(id = R.string.temperatureMin) + " " + item.tempMin,
            color = Color.White,
            style = MaterialTheme.typography.caption,
            fontSize = 14.sp,
            modifier = Modifier
                .padding(10.dp)
        )
    }
}


@Composable
fun LoadingComponent() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(color = Color.White),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        CircularProgressIndicator()
    }
}

