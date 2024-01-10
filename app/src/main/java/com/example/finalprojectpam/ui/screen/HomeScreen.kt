package com.example.finalprojectpam.ui.screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.DateRange
import androidx.compose.material.icons.filled.Info
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.material.icons.filled.Star
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.input.nestedscroll.nestedScroll
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.finalprojectpam.R
import com.example.finalprojectpam.data.Resep
import com.example.finalprojectpam.navigation.DestinasiNavigasi
import com.example.finalprojectpam.ui.model.PenyediaViewModel
import com.example.finalprojectpam.ui.model.HomeViewModel
import com.example.project8_classc.navigation.TopAppBarResep


object DestinasiHome : DestinasiNavigasi {
    override val route = "home"
    override val titleRes = R.string.app_name
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen(
    modifier: Modifier = Modifier,
    onDetailClick: (Int) -> Unit = {},
    viewModel: HomeViewModel = viewModel(factory = PenyediaViewModel.Factory)
){
    val scrollBehavior = TopAppBarDefaults.enterAlwaysScrollBehavior()

    Scaffold(
        modifier = modifier.nestedScroll(scrollBehavior.nestedScrollConnection),
        topBar = {
            TopAppBarResep(
                title = stringResource(DestinasiHome.titleRes) ,
                canNavigasiBack = false,
                scrollBehavior = scrollBehavior
            )
        },

    ) { innerPadding ->
        val uiStateResep by viewModel.resepUIState.collectAsState()
        HomeStatus(
            itemResep = uiStateResep.listResep,
            modifier = Modifier
                .padding(innerPadding)
                .fillMaxSize(),
            onDetailClick = onDetailClick
        )

    }
}

@Composable
fun HomeStatus(
    itemResep: List<Resep>,
    modifier: Modifier = Modifier,
    onDetailClick: (Int) -> Unit = {},
){
    Column (
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = modifier
    ){
        if (itemResep.isEmpty()){
            Text(
                text = "Tidak ada data Resep",
                textAlign = TextAlign.Center,
                style = MaterialTheme.typography.titleLarge
            )
        }else{
            RecipeLayout(
                itemResep = itemResep,
                modifier = Modifier.padding(8.dp),
                onDetailClick = {onDetailClick(it.id)}

            )
        }
    }
}

@Composable
fun OnLoading(modifier: Modifier = Modifier){
    Image(
        modifier = modifier.size(200.dp),
        painter = painterResource(id = R.drawable.loading_img),
        contentDescription = stringResource(R. string.loading)
    )
}

@Composable
fun OnError(
    retryAction: () -> Unit,
    modifier: Modifier = Modifier
){
    Column(
        modifier = modifier,
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Image(
            painter = painterResource(id = R.drawable.ic_connection_error) ,
            contentDescription = ""
        )
        Text(stringResource(R.string.retry))
    }
}

@Composable
fun RecipeLayout(
    itemResep: List<Resep>,
    modifier: Modifier = Modifier,
    onDetailClick: (Resep) -> Unit
){
    LazyColumn(
        modifier = modifier,
        contentPadding = PaddingValues(16.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ){
        items(items = itemResep, key = {it.id}){resep ->
            RecipeCard(
                resep = resep,
                modifier = Modifier
                    .padding(8.dp)
                    .clickable { onDetailClick(resep) }
            )
        }
    }
}

@Composable
fun RecipeCard(
    resep: Resep,
    modifier: Modifier = Modifier
){
    Card(
        modifier = modifier,
        shape = MaterialTheme.shapes.medium,
        elevation = CardDefaults.cardElevation(defaultElevation = 8.dp)
    ) {
        Column(
            modifier = Modifier.padding(16.dp),
            verticalArrangement = Arrangement.spacedBy(10.dp)
        ) {
            Column (
                modifier = Modifier.fillMaxWidth(),
                horizontalAlignment = Alignment.CenterHorizontally
            ){
                Row (
                    modifier = Modifier.fillMaxWidth(),
                    verticalAlignment = Alignment.CenterVertically
                ) {
//                    Image(bitmap = , contentDescription = )
//                    Spacer(Modifier.padding(10.dp))
//                    Text(
//                        text = kontak.nama,
//                        style = MaterialTheme.typography.titleLarge
//                    )
                }
                Row (
                    modifier = Modifier.fillMaxWidth(),
                    verticalAlignment = Alignment.CenterVertically
                ){
//                    Icon(
//                        imageVector = Icons.Default.Phone,
//                        contentDescription = null
//                    )
//                    Spacer(Modifier.padding(10.dp))
                    Text(
                        text = resep.nama_resep,
                        style = MaterialTheme.typography.titleLarge
                    )
                }
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Icon(
                        imageVector = Icons.Default.ShoppingCart,
                        contentDescription = null
                    )
                    Spacer(Modifier.padding(10.dp))
                    Text(
                        text = resep.bahan_resep,
                        style = MaterialTheme.typography.titleMedium
                    )
                }
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Icon(
                        imageVector = Icons.Default.DateRange,
                        contentDescription = null
                    )
                    Spacer(Modifier.padding(10.dp))
                    Text(
                        text = resep.waktu,
                        style = MaterialTheme.typography.titleMedium
                    )
                }
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Icon(
                        imageVector = Icons.Default.Star,
                        contentDescription = null
                    )
                    Spacer(Modifier.padding(10.dp))
                    Text(
                        text = resep.porsi,
                        style = MaterialTheme.typography.titleMedium
                    )
                }
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Icon(
                        imageVector = Icons.Default.Info,
                        contentDescription = null
                    )
                    Spacer(Modifier.padding(10.dp))
                    Text(
                        text = resep.kategori,
                        style = MaterialTheme.typography.titleMedium
                    )
                }
            }
        }
    }
}