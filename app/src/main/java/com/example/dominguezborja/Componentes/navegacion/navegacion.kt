package com.example.dominguezborja.Componentes.navegacion

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.remember
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation3.runtime.NavEntry
import androidx.navigation3.ui.NavDisplay
import com.example.dominguezborja.pantallas.Agregar
import com.example.dominguezborja.pantallas.Home
import com.example.dominguezborja.pantallas.Login

@Composable
fun BasicNavigation(){
    val backStack = remember { mutableStateListOf<Any>(Routes.Login) }

    NavDisplay(
        backStack = backStack,
        onBack = { backStack.removeLastOrNull() },
        entryProvider = {
                key ->
            when(key){
                is Routes.Login -> NavEntry(key) {
                    Login(
                        entrar = {backStack.add(Routes.Home)}
                    )
                }
                is Routes.Home -> NavEntry(key){
                    Home(
                        agregarJugador = { backStack.add(Routes.Agregar) },
                    )
                }
                is Routes.Agregar -> NavEntry(key){
                    Agregar(
                        cancelar = {backStack.removeLastOrNull()}
                    )
                }

                else -> NavEntry(key = Unit) {
                    Text("error Navegacion")
                }
            }
        }
    )
}