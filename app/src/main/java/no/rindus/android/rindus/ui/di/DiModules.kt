package no.rindus.android.rindus.ui.di

import android.app.Application
import android.content.res.Resources
import kotlinx.coroutines.Dispatchers
import no.rindus.android.rindus.BuildConfig
import no.rindus.android.rindus.data.api.Api
import no.rindus.android.rindus.data.api.LoggingInterceptor
import no.rindus.android.rindus.data.api.api
import no.rindus.android.rindus.data.api.httpClient
import no.rindus.android.rindus.data.api.provideMoshi
import no.rindus.android.rindus.data.api.retrofit
import no.rindus.android.rindus.data.store.ForecastStore
import no.rindus.android.rindus.domain.usecase.ForecastUseCase
import no.rindus.android.rindus.ui.forecast.components.forecast.ForecastViewModel
import org.koin.android.ext.koin.androidContext
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.core.context.startKoin
import org.koin.dsl.bind
import org.koin.dsl.module

private val frameworkModule = module {
    single { Dispatchers.IO }
    single { androidContext().resources } bind Resources::class
    single { api<Api>(retrofit(provideMoshi(), httpClient(get()))) }
    single { LoggingInterceptor(BuildConfig.DEBUG) }
}

private val dataSourceModule = module {
    single { ForecastStore(get()) }
}

private val useCaseModule = module {
    factory { ForecastUseCase(get(), get()) }
}

private val vmModule = module {
    viewModel { ForecastViewModel(get()) }
}

fun setupDependency(application: Application) {
    startKoin {
        androidContext(application)
        modules(
            frameworkModule,
            vmModule,
            dataSourceModule,
            useCaseModule
        )
    }
}
