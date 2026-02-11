package com.example.dominguezborja.Componentes.navegacion

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.remember
import androidx.navigation3.runtime.NavEntry
import androidx.navigation3.ui.NavDisplay

@Composable
fun BasicNavigation(){
    val backStack = remember { mutableStateListOf<Any>(Routes.login) }

    NavDisplay(
        backStack = backStack,
        onBack = { backStack.removeLastOrNull() },
        entryProvider = {
                key ->
            when(key){
                is Routes.login -> NavEntry(key) {
                }

                else -> NavEntry(key = Unit) {
                    Text("error Navegacion")
                }
            }
        }
    )
}