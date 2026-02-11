package com.example.dominguezborja.pantallas

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.dominguezborja.Componentes.Crud.Jugador
import com.example.dominguezborja.Componentes.Crud.ViewModelCrud

@Composable
fun Home(viewmodel: ViewModelCrud){

    Spacer(modifier = Modifier.padding(15.dp))
    Column (modifier = Modifier.padding(5.dp)
        .fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally){
        Text("Plantilla temporada 25/26", fontSize = 30.sp)
        Spacer(modifier = Modifier.padding())

        LazyColumn {

        }
    }
}