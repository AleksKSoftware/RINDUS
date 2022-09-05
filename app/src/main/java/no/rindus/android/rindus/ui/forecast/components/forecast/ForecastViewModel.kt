package no.rindus.android.rindus.ui.forecast.components.forecast

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import no.rindus.android.rindus.domain.entitiy.Forecast
import no.rindus.android.rindus.domain.usecase.ForecastUseCase
import no.rindus.android.rindus.ui.forecast.UIState

/**
 * ViewModel is communicator between different [ForecastViewModel] of an Activity.
 */

class ForecastViewModel(private val usecase: ForecastUseCase) : ViewModel() {

    private val mutableStateFlow = MutableStateFlow<UIState>(UIState.LoadingState)

    val screenStates: StateFlow<UIState> = mutableStateFlow

    private val list = mutableListOf<Forecast>()

    init {
        getForecast()
    }

    private fun getForecast() =
        viewModelScope.launch {
            usecase.launch().fold(
                onSuccess = {
                    mutableStateFlow.value = UIState.ShowList(list = it)
                    list.addAll(it)
                },
                onFailure = { mutableStateFlow.value = UIState.ErrorState }
            )
        }

}
