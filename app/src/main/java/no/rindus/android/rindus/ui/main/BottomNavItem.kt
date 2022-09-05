package no.rindus.android.rindus.ui.main

import no.rindus.android.rindus.R

sealed class BottomNavItem(var title: String, var icon: Int, var screen_route: String) {

    object Weather : BottomNavItem("Weather", R.drawable.ic_beach, "weather")
    object Web : BottomNavItem("Web", R.drawable.ic_web, "web")
}