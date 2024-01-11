package com.example.finalprojectpam.Profile.Screen

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.finalprojectpam.Profile.Profil
import com.example.finalprojectpam.Profile.ProfileViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AddDataProfileScreen (
    navController: NavController,
    profileViewModel: ProfileViewModel,
){
    var idProfil: String by remember { mutableStateOf("") }
    var nama_pengguna: String by remember { mutableStateOf("") }
    var username: String by remember { mutableStateOf("") }
    var email: String by remember { mutableStateOf("") }
    var jenis_kelamin: String by remember { mutableStateOf("") }
    var tanggal_lahir: String by remember { mutableStateOf("") }

    val context = LocalContext.current

    // main Layout
    Column(modifier = Modifier.fillMaxSize()) {
        // back button
        Row(
            modifier = Modifier
                .padding(start = 15.dp, top = 15.dp)
                .fillMaxWidth(),
            horizontalArrangement = Arrangement.Start
        ) {
            IconButton(
                onClick = { navController.popBackStack() }
            ) {
                Icon(imageVector = Icons.Filled.ArrowBack, contentDescription = "back_button")
            }
        }
        // add data Layout
        Column(
            modifier = Modifier
                .padding(start = 60.dp, end = 60.dp, bottom = 50.dp)
                .fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            // ID
            OutlinedTextField(
                modifier = Modifier.fillMaxWidth(),
                value = idProfil,
                onValueChange = {
                    idProfil = it
                },
                label = {
                    Text(text = "ID Profile")
                }
            )
            // Name
            OutlinedTextField(
                modifier = Modifier.fillMaxWidth(),
                value = nama_pengguna,
                onValueChange = {
                    nama_pengguna = it
                },
                label = {
                    Text(text = "Nama Pengguna")
                }
            )

            OutlinedTextField(
                modifier = Modifier.fillMaxWidth(),
                value = username,
                onValueChange = {
                    username = it
                },
                label = {
                    Text(text = "Username")
                }
            )

            OutlinedTextField(
                modifier = Modifier.fillMaxWidth(),
                value = email,
                onValueChange = {
                    email = it
                },
                label = {
                    Text(text = "Email")
                }
            )

            OutlinedTextField(
                modifier = Modifier.fillMaxWidth(),
                value = jenis_kelamin,
                onValueChange = {
                    jenis_kelamin = it
                },
                label = {
                    Text(text = "Jenis Kelamin")
                },

            )

            OutlinedTextField(
                modifier = Modifier.fillMaxWidth(),
                value = tanggal_lahir,
                onValueChange = {
                    tanggal_lahir = it
                },
                label = {
                    Text(text = "Tanggal Lahi")
                },

            )
            // save Button
            Button(
                modifier = Modifier
                    .padding(top = 50.dp)
                    .fillMaxWidth(),
                onClick = {
                    val profil = Profil(
                        idProfil = idProfil,
                        nama_pengguna = nama_pengguna,
                        username = username,
                        email = email,
                        jenis_kelamin = jenis_kelamin,
                        tanggal_lahir = tanggal_lahir
                    )

                    profileViewModel.saveData(profil = profil, context = context)
                }
            ) {
                Text(text = "Save")
            }
        }
    }
}