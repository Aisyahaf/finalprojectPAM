package com.example.finalprojectpam.ui.screen

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.Divider
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.input.nestedscroll.nestedScroll
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.finalprojectpam.R
import com.example.finalprojectpam.navigation.DestinasiNavigasi
import com.example.finalprojectpam.ui.model.PenyediaViewModel
import com.example.finalprojectpam.ui.model.InsertUiEvent
import com.example.finalprojectpam.ui.model.InsertUiState
import com.example.finalprojectpam.ui.model.InsertViewModel
import com.example.finalprojectpam.ui.theme.FinalprojectPAMTheme
import com.example.project8_classc.navigation.TopAppBarResep
import kotlinx.coroutines.launch


object DestinasiEntry: DestinasiNavigasi {
    override val route = "item_entry"
    override val titleRes = R.string.entry_resep
}
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun EntryResepScreen(
//    navigateBack: () -> Unit,
    modifier: Modifier = Modifier,
    viewModel: InsertViewModel = viewModel(factory = PenyediaViewModel.Factory),
){
    val coroutineScope = rememberCoroutineScope()
    val scrollBehavior = TopAppBarDefaults.enterAlwaysScrollBehavior()
    Scaffold (
        modifier = modifier.nestedScroll(scrollBehavior.nestedScrollConnection),
        topBar = {
            TopAppBarResep(
                title = stringResource(DestinasiEntry.titleRes),
                canNavigasiBack = true,
                scrollBehavior = scrollBehavior
            )
        }
    ){innerPadding ->
        EntryResepBody(
            insertUiState = viewModel.uiStateResep,
            onResepValueChange = viewModel::updateUiState,
            onSaveClick = {
                coroutineScope.launch {
                    viewModel.saveResep()
                }
            },
            modifier = Modifier
                .padding(innerPadding)
                .verticalScroll(rememberScrollState())
                .fillMaxWidth()
        )
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun FormInputResep(
    insertUiEvent: InsertUiEvent,
    modifier: Modifier = Modifier,
    onValueChange: (InsertUiEvent) -> Unit = {},
    enabled: Boolean = true
){
    Column(
        modifier = modifier,
        verticalArrangement = Arrangement.spacedBy(12.dp)
    ) {
        OutlinedTextField(
            value = insertUiEvent.nama_resep,
            onValueChange = {onValueChange(insertUiEvent.copy(nama_resep = it))},
            label = { Text("Judul Resep") },
            modifier = Modifier.fillMaxWidth(),
            enabled = enabled,
            singleLine = true
        )
        OutlinedTextField(
            value = insertUiEvent.kategori,
            onValueChange = {onValueChange(insertUiEvent.copy(kategori = it))},
            label = { Text("Jenis") },
            modifier = Modifier.fillMaxWidth(),
            enabled = enabled,
            singleLine = true
        )
        OutlinedTextField(
            value = insertUiEvent.bahan_resep,
            onValueChange = {onValueChange(insertUiEvent.copy(bahan_resep = it))},
            label = { Text("Bahan-bahan") },
            modifier = Modifier.fillMaxWidth(),
            enabled = enabled,
            singleLine = true
        )
        OutlinedTextField(
            value = insertUiEvent.porsi,
            onValueChange = {onValueChange(insertUiEvent.copy(porsi = it))},
            label = { Text("Porsi") },
            modifier = Modifier.fillMaxWidth(),
            enabled = enabled,
            singleLine = true
        )
        OutlinedTextField(
            value = insertUiEvent.waktu,
            onValueChange = {onValueChange(insertUiEvent.copy(waktu = it))},
            label = { Text("Waktu") },
            modifier = Modifier.fillMaxWidth(),
            enabled = enabled,
            singleLine = true
        )
        OutlinedTextField(
            value = insertUiEvent.deskripsi,
            onValueChange = {onValueChange(insertUiEvent.copy(deskripsi = it))},
            label = { Text("Deskripsi") },
            modifier = Modifier.fillMaxWidth(),
            enabled = enabled,
            singleLine = true
        )
        if (enabled){
            Text(
                text = "Isi semua data",
                modifier = Modifier.padding(start = 12.dp)
            )
        }
        Divider(
            thickness = 8.dp,
            modifier = Modifier.padding(12.dp)
        )
    }
}

@Composable
fun EntryResepBody(
    insertUiState: InsertUiState,
    onResepValueChange: (InsertUiEvent) -> Unit,
    onSaveClick: () -> Unit,
    modifier: Modifier = Modifier
){
    Column(
        verticalArrangement = Arrangement.spacedBy(18.dp),
        modifier = modifier.padding(12.dp)
    ) {
        FormInputResep(
            insertUiEvent = insertUiState.insertUiEvent,
            onValueChange = onResepValueChange,
            modifier = Modifier.fillMaxWidth()
        )
        Button(
            onClick = onSaveClick,
            shape = MaterialTheme.shapes.small,
            modifier = Modifier.fillMaxWidth()
        ) {
            Text(text = "Simpan")
        }
    }
}

@Composable
fun GreetingPreview() {
    FinalprojectPAMTheme {
        EntryResepScreen()
    }
}