package no.rindus.android.rindus.data.store

import no.rindus.android.rindus.data.api.Api
import no.rindus.android.rindus.data.entity.ForecastParams
import no.rindus.android.rindus.data.entity.ResponseForecast

/**
 * The class is responsible for the source of data
 */
class ForecastStore(private val api: Api) {

    suspend fun getForecast(): ResponseForecast {
        val params = ForecastParams()
        return api.getForecast(params.q, params.units, params.appid)
    }
}

