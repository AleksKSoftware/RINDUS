package no.rindus.android.rindus.data.entity

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class ForecastResponse(
    @Json(name = "main") val mainData: MainForecastData,
    @Json(name = "dt_txt") val time: String,
)
