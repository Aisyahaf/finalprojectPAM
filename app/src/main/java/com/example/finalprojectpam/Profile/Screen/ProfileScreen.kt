package com.example.finalprojectpam.Profile.Screen

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.BlendMode.Companion.Screen
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.example.finalprojectpam.Navigasi.Screens
import com.example.finalprojectpam.Profile.Profil
import com.example.finalprojectpam.Profile.ProfileViewModel
import java.time.format.TextStyle

@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun ProfileScreen(
    navController: NavController,
    profileViewModel: ProfileViewModel = viewModel()
) {
    val allDataState by profileViewModel.getAllData().collectAsState(initial = emptyList())

    LazyColumn(
        modifier = Modifier
            .padding(16.dp)
            .fillMaxSize()
    ) {
        item {
            Text(
                text = "Profile Data",
                style = androidx.compose.ui.text.TextStyle(
                    fontSize = 20.sp,
                    fontWeight = FontWeight.Bold
                ),
                modifier = Modifier.padding(bottom = 16.dp)
            )
        }

        items(allDataState) { profileData ->
            ProfileListItem(profileData = profileData)
        }

        item {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 16.dp),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {

                IconButton(
                    onClick = { navController.navigateUp() }
                ) {
                    Icon(imageVector = Icons.Filled.ArrowBack, contentDescription = "Back")
                }

                OutlinedButton(
                    onClick = {  navController.navigate(route = Screens.AddDataProfileScreen.route) },
                ) {
                    Text(text = "Add Data Profile")
                }

                OutlinedButton(
                    onClick = { navController.navigate(route = Screens.GetDataProfileScreen.route) },
                ) {
                    Text(text = "Get Data Profile")
                }
            }
        }
    }
}


@Composable
fun ProfileListItem(profileData: Profil) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .border(1.dp, Color.Gray)
            .padding(8.dp)
    ) {
        Column {
            Text(text = "ID: ${profileData.idProfil}", fontSize = 16.sp)
            Text(text = "Nama: ${profileData.nama_pengguna}")
            Text(text = "Username: ${profileData.username}")
            Text(text = "Email: ${profileData.email}")
            Text(text = "Jenis Kelamin: ${profileData.jenis_kelamin}")
            Text(text = "Tanggal Lahir: ${profileData.tanggal_lahir}")
        }
    }
}