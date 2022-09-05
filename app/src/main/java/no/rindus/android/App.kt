package no.rindus.android

import android.app.Application
import no.rindus.android.rindus.ui.di.setupDependency

/**
 * [App] class for maintaining global application state and contains injection of [Koin].
 */
class App: Application() {
    override fun onCreate() {
        super.onCreate()
        setupDependency(this)
    }
}