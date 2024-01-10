package com.example.finalprojectpam.navigation

import com.example.finalprojectpam.R

sealed class BottomBarScreen(
    val icon: Int,
    val icon_focused : Int,
    val route: String,
    val titleRes: String
) {
    object Home: BottomBarScreen(
        route = "home",
        titleRes = "Home",
        icon = R.drawable.home_icon,
        icon_focused = R.drawable.home_icon_focus
    )

    object Resep: BottomBarScreen(
        route = "resep",
        titleRes = "Resep",
        icon = R.drawable.add_resep_icon,
        icon_focused = R.drawable.add_resep_icon_focus
    )

    object Profile: BottomBarScreen(
        route = "profile",
        titleRes = "Profile",
        icon = R.drawable.profile_icon,
        icon_focused = R.drawable.profile_icon_focus
    )
}