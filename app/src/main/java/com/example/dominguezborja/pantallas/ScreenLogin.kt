package com.example.dominguezborja.pantallas

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.dominguezborja.R
import com.example.dominguezborja.UiState.ViewModelLogin
import com.example.dominguezborja.ui.theme.DominguezBorjaTheme

@Composable
fun Login(viewmodel: ViewModelLogin = viewModel(), entrar:() -> Unit){
    val uiState by viewmodel.uiState.collectAsState()

    Column (modifier = Modifier.padding(5.dp)
        .fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally){

        Image(painterResource(R.drawable.logo),
            contentDescription = "logo")

        Text("Iniciar Sesión")

        TextField(value = uiState.email,
            onValueChange = {viewmodel.onEmailChange(it)},
            modifier = Modifier.padding(10.dp)
                .fillMaxWidth(),
            label = {Text("Email")}
        )

        TextField(value = uiState.contraseña,
            onValueChange = {viewmodel.onContraseña(it)},
            modifier = Modifier.padding(10.dp)
                .fillMaxWidth(),
            label = {Text("Contraseña")},
            keyboardOptions = KeyboardOptions(
                keyboardType =
                    KeyboardType.Password)
            )

        Button(onClick = {viewmodel.login(
            onSuccess = entrar,
            onError = {println(it)}
        )}, modifier = Modifier.fillMaxWidth()
            .padding(10.dp)
            .background(Color(0xFF27D21F))) {
            Text("Login")
        }
    }
}
