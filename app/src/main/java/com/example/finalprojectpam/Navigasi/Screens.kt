package com.example.finalprojectpam.Navigasi

sealed class Screens(val route: String) {
    object ProfileScreen: Screens(route = "profile_screen")
    object GetDataProfileScreen: Screens(route = "get_data_Profile_screen")
    object AddDataProfileScreen: Screens(route = "add_data_Profile_screen")
    object AuthScreen : Screens(route = "auth_screen") // Tambahkan opsi untuk AuthScreen
    object HomeScreen : Screens(route = "home_screen")
    object ResepScreen: Screens(route = "resep_screen")
    object GetDataResepScreen: Screens(route = "get_data_Resep_screen")
    object AddDataResepScreen: Screens(route = "add_data_Resep_screen")

}