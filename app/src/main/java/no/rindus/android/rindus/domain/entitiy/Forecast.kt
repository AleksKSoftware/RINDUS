package no.rindus.android.rindus.domain.entitiy


data class Forecast(
    val temp: String? = "",
    val feelsLike: String?,
    val tempMin: String?,
    val tempMax: String?,
    val pressure: String?,
    val seaLevel: String?,
    val grndLevel: String?,
    val humidity: String?,
    val tempKf: String?,
    val time: String,
)
