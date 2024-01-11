package com.example.finalprojectpam.Resep.Screen

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
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
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.finalprojectpam.Resep.Resep
import com.example.finalprojectpam.Resep.ResepViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AddDataResepScreen (
    navController: NavController,
    resepViewModel: ResepViewModel,
){
    var id: String by remember { mutableStateOf("") }
    var idProfil: String by remember { mutableStateOf("") }
    var nama_resep: String by remember { mutableStateOf("") }
    var bahan_resep: String by remember { mutableStateOf("") }
    var deskripsi: String by remember { mutableStateOf("") }
    var waktu: String by remember { mutableStateOf("") }
    var porsi: String by remember { mutableStateOf("") }
    var kategori: String by remember { mutableStateOf("") }

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
                value = id,
                onValueChange = {
                    id = it
                },
                label = {
                    Text(text = "ID Resep")
                }
            )
            // Name

            OutlinedTextField(
                modifier = Modifier.fillMaxWidth(),
                value = nama_resep,
                onValueChange = {
                    nama_resep = it
                },
                label = {
                    Text(text = "Nama Resep")
                }
            )

            OutlinedTextField(
                modifier = Modifier.fillMaxWidth(),
                value = kategori,
                onValueChange = {
                    kategori = it
                },
                label = {
                    Text(text = "Kategori Resep")
                }
            )

            OutlinedTextField(
                modifier = Modifier.fillMaxWidth(),
                value = bahan_resep,
                onValueChange = {
                    bahan_resep = it
                },
                label = {
                    Text(text = "Bahan Resep")
                }
            )

            OutlinedTextField(
                modifier = Modifier.fillMaxWidth(),
                value = deskripsi,
                onValueChange = {
                    deskripsi = it
                },
                label = {
                    Text(text = "Deskripsi")
                }
            )

            OutlinedTextField(
                modifier = Modifier.fillMaxWidth(),
                value = waktu,
                onValueChange = {
                    waktu = it
                },
                label = {
                    Text(text = "Waktu Pembuatan")
                }
            )

            OutlinedTextField(
                modifier = Modifier.fillMaxWidth(),
                value = porsi,
                onValueChange = {
                    porsi = it
                },
                label = {
                    Text(text = "Porsi")
                }
            )



            // save Button
            Button(
                modifier = Modifier
                    .padding(top = 50.dp)
                    .fillMaxWidth(),
                onClick = {
                    val resep = Resep(
                        id = id,
                        idProfil = idProfil,
                        nama_resep = nama_resep,
                        bahan_resep = bahan_resep,
                        kategori = kategori,
                        deskripsi = deskripsi,
                        waktu = waktu,
                        porsi = porsi
                    )

                    resepViewModel.saveData(resep = resep, context = context)
                }
            ) {
                Text(text = "Save")
            }
        }
    }
}