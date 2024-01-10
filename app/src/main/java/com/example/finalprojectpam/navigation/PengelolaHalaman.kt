package com.example.project8_classc.navigation

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarScrollBehavior
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.finalprojectpam.navigation.BottomBarScreen
import com.example.finalprojectpam.ui.screen.HomeScreen
import com.example.finalprojectpam.ui.screen.ProfileScreen
import com.example.finalprojectpam.ui.screen.EntryResepScreen

@Composable
fun  RecipeApp(navController: NavHostController = rememberNavController()){
    PengelolaHalaman(navController = navController)
}
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TopAppBarResep(
    title: String,
    canNavigasiBack: Boolean,
    modifier: Modifier = Modifier,
    scrollBehavior: TopAppBarScrollBehavior? = null,
    navigateUp: () -> Unit = {}
){
    CenterAlignedTopAppBar(title = { Text(title) },
        modifier = modifier,
        scrollBehavior = scrollBehavior,
        navigationIcon = {
            if (canNavigasiBack){
                IconButton(onClick = navigateUp) {
                    Icon(
                        imageVector = Icons.Filled.ArrowBack,
                        contentDescription = ""
                    )
                }
            }
        }
    )
}
@Composable
fun PengelolaHalaman(
    navController: NavHostController = rememberNavController()
){
    NavHost(
        navController = navController,
        startDestination = BottomBarScreen.Home.route,
        modifier = Modifier,
    ){
        composable(route = BottomBarScreen.Home.route){
            HomeScreen()
        }

        composable(route = BottomBarScreen.Resep.route){
            EntryResepScreen()
        }

        composable(route = BottomBarScreen.Profile.route){
            ProfileScreen()
        }
    }
}