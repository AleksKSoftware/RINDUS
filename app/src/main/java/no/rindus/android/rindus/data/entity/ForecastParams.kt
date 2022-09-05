package no.rindus.android.rindus.data.entity

import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class ForecastParams(
    val q: String = "Dusseldorf,de",
    val units: String = "metric",
    val appid: String = "b0148f16d3df8cdafe410daf9d01bcd7",
)
