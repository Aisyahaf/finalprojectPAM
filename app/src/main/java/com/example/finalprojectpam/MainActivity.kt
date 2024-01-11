package com.example.finalprojectpam

import android.os.Build
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.annotation.RequiresApi
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.finalprojectpam.Authentication.AuthViewModel
import com.example.finalprojectpam.HomePage.HomeViewModel
import com.example.finalprojectpam.Navigasi.PengelolaHalaman
import com.example.finalprojectpam.Profile.ProfileViewModel
import com.example.finalprojectpam.Resep.ResepViewModel
import com.example.finalprojectpam.ui.theme.FinalprojectPAMTheme
import com.google.firebase.Firebase
import com.google.firebase.firestore.firestore


class MainActivity : ComponentActivity() {

    val db_resep = Firebase.firestore
    private lateinit var navController: NavHostController
    private val profileViewModel: ProfileViewModel by viewModels()
    private val resepViewModel: ResepViewModel by viewModels()
    private val homeViewModel: HomeViewModel by viewModels()
    private val authViewModel: AuthViewModel by viewModels()


    @RequiresApi(Build.VERSION_CODES.O)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            FinalprojectPAMTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    navController = rememberNavController()
                    PengelolaHalaman(
                        navController = navController,
                        profileViewModel = profileViewModel,
                        resepViewModel = resepViewModel,
                        homeViewModel = homeViewModel,
                        authViewModel = authViewModel,
                    )
                }
            }
        }
    }
}