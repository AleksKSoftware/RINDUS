package no.rindus.android.rindus.data.entity

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class MainForecastData(
    @Json(name = "temp") val temp: String?,
    @Json(name = "feels_like") val feelsLike: String?,
    @Json(name = "temp_min") val tempMin: String?,
    @Json(name = "temp_max") val tempMax: String?,
    @Json(name = "pressure") val pressure: String?,
    @Json(name = "sea_level") val seaLevel: String?,
    @Json(name = "grnd_level") val grndLevel: String?,
    @Json(name = "humidity") val humidity: String?,
    @Json(name = "temp_kf") val tempKf: String?,
)
