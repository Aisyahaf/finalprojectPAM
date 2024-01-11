package com.example.finalprojectpam.Navigasi

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.finalprojectpam.Authentication.AuthScreen
import com.example.finalprojectpam.Authentication.AuthViewModel
import com.example.finalprojectpam.HomePage.HomeScreen
import com.example.finalprojectpam.HomePage.HomeViewModel
import com.example.finalprojectpam.Profile.ProfileViewModel
import com.example.finalprojectpam.Profile.Screen.AddDataProfileScreen
import com.example.finalprojectpam.Profile.Screen.GetDataProfileScreen
import com.example.finalprojectpam.Profile.Screen.ProfileScreen
import com.example.finalprojectpam.Resep.ResepViewModel
import com.example.finalprojectpam.Resep.Screen.AddDataResepScreen
import com.example.finalprojectpam.Resep.Screen.GetDataResepScreen
import com.example.finalprojectpam.Resep.Screen.ResepScreen

@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun PengelolaHalaman(
    navController: NavHostController,
    resepViewModel: ResepViewModel,
    profileViewModel: ProfileViewModel,
    homeViewModel: HomeViewModel,
    authViewModel: AuthViewModel,

    ){
    NavHost(
        navController = navController,
        startDestination = Screens.AuthScreen.route
    ) {

        composable(route = Screens.AuthScreen.route) {
            AuthScreen(
                navController = navController,
                authViewModel = authViewModel,
            )
        }
        composable(
            route = Screens.HomeScreen.route
        ) {
            HomeScreen(navController = navController, homeViewModel = homeViewModel)
        }
        // main screen
        composable(
            route = Screens.ProfileScreen.route
        ) {
            ProfileScreen(navController = navController, profileViewModel = ProfileViewModel())
        }
        // get data screen
        composable(
            route = Screens.GetDataProfileScreen.route
        ) {
            GetDataProfileScreen(navController = navController, profileViewModel = ProfileViewModel())

        }
        // add data screen
        composable(
            route = Screens.AddDataProfileScreen.route
        ){
            AddDataProfileScreen(navController = navController, profileViewModel = ProfileViewModel())
        }

        composable(
            route = Screens.ResepScreen.route
        ) {
            ResepScreen(navController = navController, resepViewModel = ResepViewModel())
        }
        // get data screen
        composable(
            route = Screens.GetDataResepScreen.route
        ) {
            GetDataResepScreen(navController = navController, resepViewModel = ResepViewModel())

        }
        // add data screen
        composable(
            route = Screens.AddDataResepScreen.route
        ){
            AddDataResepScreen(navController = navController, resepViewModel = ResepViewModel())
        }
    }
}
