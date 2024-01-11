package com.example.finalprojectpam.ui.screen

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.finalprojectpam.R
import com.example.finalprojectpam.navigation.DestinasiNavigasi
import com.example.finalprojectpam.ui.model.PenyediaViewModel
import com.example.finalprojectpam.ui.model.EditViewModel
import com.example.project8_classc.navigation.TopAppBarResep
import kotlinx.coroutines.launch

object ItemEditDestination : DestinasiNavigasi{
    override val route = "item_edit"
    override val titleRes = R.string.edit_resep
    const val resepIdArg = "resepId"
    val routeWithArgs = "$route/{$resepIdArg}"
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ItemEditScreen(
    onNavigateUp: () -> Unit,
    modifier: Modifier = Modifier,
    viewModel: EditViewModel = viewModel(factory = PenyediaViewModel.Factory)
){
    val coroutineScope = rememberCoroutineScope()
    Scaffold(
        topBar = {
            TopAppBarResep(
                title = stringResource(ItemEditDestination.titleRes),
                canNavigasiBack = true,
                navigateUp = onNavigateUp
            )
        },
        modifier = modifier
    ) {innerPadding ->
        EntryResepBody(
            insertUiState = viewModel.resepUiState,
            onResepValueChange = viewModel::updateUiState,
            onSaveClick = {
                coroutineScope.launch {
                    viewModel.updateResep()
                }
            },
            modifier = Modifier.padding(innerPadding)
        )
    }
}