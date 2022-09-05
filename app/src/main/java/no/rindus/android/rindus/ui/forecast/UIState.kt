package no.rindus.android.rindus.ui.forecast

import no.rindus.android.rindus.domain.entitiy.Forecast

/**
 * UI states of the countries list
 */

sealed class UIState {
    object LoadingState : UIState()
    data class ShowList(val list: List<Forecast>) : UIState()
    object ErrorState : UIState()
}
