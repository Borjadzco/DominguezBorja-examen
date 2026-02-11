package com.example.dominguezborja.pantallas

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyItemScope
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.dominguezborja.Componentes.Crud.Jugador
import com.example.dominguezborja.Componentes.Crud.ViewModelCrud
import com.example.dominguezborja.UiState.UiStateLogin

@Composable
fun Home(viewmodel: ViewModelCrud = viewModel(),
         agregarJugador:() -> Unit){
    val jugador by viewmodel.uistate.collectAsState()


    Column (modifier = Modifier.padding(5.dp)
        .fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally){
        Spacer(modifier = Modifier.padding(20.dp))
        Text("Plantilla temporada 25/26", fontSize = 30.sp)
        Spacer(modifier = Modifier.padding(20.dp))

        LazyColumn {
            items(jugador) { jugado ->
                ProdItemCard(
                    jugador = jugado,
                    onDelete = { id -> viewmodel.deleteJugador(id) }
                )
            }
        }
        Button(onClick = {
            agregarJugador() },
            modifier = Modifier.fillMaxWidth()
            ) {
            Text("Agregar jugador")
        }
    }
}