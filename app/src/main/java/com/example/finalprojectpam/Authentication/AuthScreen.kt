package com.example.finalprojectpam.Authentication

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.example.finalprojectpam.Navigasi.Screens

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AuthScreen(navController: NavController, authViewModel: AuthViewModel = viewModel()) {
    var email by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }

    var showToastMessage by remember { mutableStateOf<String?>(null) }

    val blueColor = Color(0xFF2196F3) // Warna biru

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        // Judul halaman dengan nuansa biru
        Text(
            text = "Login",
            color = blueColor,
            fontSize = 28.sp,
            fontWeight = FontWeight.Bold,
            modifier = Modifier.padding(bottom = 16.dp)
        )

        // Input Email
        TextField(
            value = email,
            onValueChange = { email = it },
            label = { Text("Email") },
            colors = TextFieldDefaults.outlinedTextFieldColors(focusedLabelColor = blueColor)
        )
        Spacer(modifier = Modifier.height(8.dp))

        // Input Password
        TextField(
            value = password,
            onValueChange = { password = it },
            label = { Text("Password") },
            visualTransformation = PasswordVisualTransformation(),
            colors = TextFieldDefaults.outlinedTextFieldColors(focusedLabelColor = blueColor)
        )
        Spacer(modifier = Modifier.height(16.dp))

        // Tombol Sign Up
        Button(onClick = { authViewModel.createUserWithEmailAndPassword(email, password) }) {
            Text("Sign Up")
        }
        Spacer(modifier = Modifier.height(8.dp))

        // Tombol Sign In
        Button(onClick = {
            authViewModel.signInWithEmailAndPassword(email, password,
                onSuccess = {
                    // Authentication successful, navigate to the desired screen
                    navController.navigate(Screens.HomeScreen.route)
                },
                onError = { errorMessage ->
                    // Show an error message to the user
                    showToastMessage = errorMessage
                })
        }) {
            Text("Sign In", color = Color.White) // Memberi warna teks putih
        }
    }
}