package com.example.dominguezborja.pantallas

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.dominguezborja.Componentes.Crud.ViewModelCrud
import com.example.dominguezborja.UiState.ViewModelLogin

@Composable
fun Agregar(viewmodel: ViewModelLogin = viewModel (),
    viewModelCrud: ViewModelCrud = viewModel(),
            cancelar:() -> Unit){
    val uiState by viewmodel.uiState.collectAsState()

    Column (modifier = Modifier.padding(5.dp)
        .fillMaxWidth()){
        Text("Nuevo jugador", fontSize = 40.sp)

        TextField(value = uiState.nombre,
            onValueChange = {viewModelCrud.onNombreChange(it)},
            modifier = Modifier.padding(10.dp)
                .fillMaxWidth(),
            label = {Text("Email")}
        )
        TextField(value = uiState.numero,
            onValueChange = {viewModelCrud.onNumeroChange(it)},
            modifier = Modifier.padding(10.dp)
                .fillMaxWidth(),
            label = {Text("Email")}
        )
        TextField(value = uiState.posicion,
            onValueChange = {viewModelCrud.onPosicionChange(it)},
            modifier = Modifier.padding(10.dp)
                .fillMaxWidth(),
            label = {Text("Email")}
        )
        TextField(value = uiState.nacionalidad,
            onValueChange = {viewModelCrud.onNacionalidadChange(it)},
            modifier = Modifier.padding(10.dp)
                .fillMaxWidth(),
            label = {Text("Email")}
        )
        TextField(value = uiState.imagen,
            onValueChange = {viewModelCrud.onImagenChange(it)},
            modifier = Modifier.padding(10.dp)
                .fillMaxWidth(),
            label = {Text("Email")}
        )
        Row {
            Button(onClick = {viewModelCrud.addJugador()}) {
                Text("Agregar Jugador")
            }
            Button(onClick = cancelar) {
                Text("Cancelar")
            }
        }

    }
}