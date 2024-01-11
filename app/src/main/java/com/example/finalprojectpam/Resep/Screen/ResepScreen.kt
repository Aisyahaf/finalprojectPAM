package com.example.finalprojectpam.Resep.Screen

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

import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.example.finalprojectpam.Navigasi.Screens
import com.example.finalprojectpam.Resep.Resep
import com.example.finalprojectpam.Resep.ResepViewModel

@Composable
fun ResepScreen(
    navController: NavController,
    resepViewModel: ResepViewModel = viewModel()
) {
    val allDataState by resepViewModel.getAllData().collectAsState(initial = emptyList())

    LazyColumn(
        modifier = Modifier
            .padding(16.dp)
            .fillMaxSize()
    ) {
        item {
            Text(
                text = "Data Resep",
                style = TextStyle(fontSize = 20.sp, fontWeight = FontWeight.Bold),
                modifier = Modifier.padding(bottom = 16.dp)
            )
        }

        items(allDataState) { resepData ->
            ResepListItem(resepData = resepData)
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
                    onClick = {navController.navigate(route = Screens.AddDataResepScreen.route) },
                ) {
                    Text(text = "Add Data Resep")
                }

                OutlinedButton(
                    onClick = {navController.navigate(route = Screens.GetDataResepScreen.route)},
                ) {
                    Text(text = "Get Data Resep")
                }
            }
        }
    }
}


@Composable
fun ResepListItem(resepData: Resep) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .border(1.dp, Color.Gray)
            .padding(8.dp)
    ) {
        Column {
            Text(text = "ID Resep: ${resepData.id}", fontSize = 16.sp)
            Text(text = "Nama Resep: ${resepData.nama_resep}")
            Text(text = "Bahan Resep: ${resepData.bahan_resep}")
            Text(text = "Kategori: ${resepData.kategori}")
            Text(text = "Deksripsi: ${resepData.deskripsi}")
            Text(text = "Waktu Pembuatan: ${resepData.waktu}")
            Text(text = "Porsi: ${resepData.porsi}")
        }
    }
}