package no.rindus.android.rindus.domain.usecase

import kotlinx.coroutines.CoroutineDispatcher
import no.rindus.android.rindus.data.mapper.ForecastConverter.toData
import no.rindus.android.rindus.data.store.ForecastStore

/**
 * The use case which managing of the population data and convert appropriate data.
 */

class ForecastUseCase(
    dispatcher: CoroutineDispatcher,
    private val forecastStore: ForecastStore,
) : BaseUseCase(dispatcher) {

    suspend fun launch() =
        wrapResult { forecastStore.getForecast().list.toData() }
}