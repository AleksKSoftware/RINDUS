package no.rindus.android.rindus.data.mapper

import no.rindus.android.rindus.data.entity.ForecastResponse
import no.rindus.android.rindus.domain.entitiy.Forecast


object ForecastConverter {

    fun List<ForecastResponse>.toData(): List<Forecast> {
        return map { val item = it.mainData
            Forecast(
                time = it.time,
                temp = item.temp,
                feelsLike = item.feelsLike,
                tempMin = item.tempMin,
                tempMax = item.tempMax,
                pressure = item.pressure,
                seaLevel = item.seaLevel,
                grndLevel = item.grndLevel,
                humidity = item.humidity,
                tempKf = item.tempKf,
            )
        }
    }
}