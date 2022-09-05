package no.rindus.android.rindus.data.api

import no.rindus.android.rindus.data.entity.ResponseForecast
import retrofit2.http.POST
import retrofit2.http.Query


interface Api {

    @POST("$DATA_VERSION/forecast")
    suspend fun getForecast(
        @Query("q") country: String,
        @Query("units") units: String,
        @Query("appid") appid: String,
    ): ResponseForecast
}

private const val DATA_VERSION = "data/2.5/"