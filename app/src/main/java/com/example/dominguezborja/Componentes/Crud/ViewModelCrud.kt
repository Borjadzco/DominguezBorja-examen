package com.example.dominguezborja.Componentes.Crud

import androidx.lifecycle.ViewModel
import com.example.dominguezborja.UiState.UiStateLogin
import com.google.firebase.Firebase
import com.google.firebase.firestore.firestore
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow

class ViewModelCrud: ViewModel() {
    class ViewModelCrud: ViewModel(){
        private val db = Firebase.firestore
        private val jogadorCollection = db.collection("jugadores")

        private val _jugador = MutableStateFlow<List<Jugador>>(emptyList())
        val producto: StateFlow<List<Jugador>> = _jugador

        private val _uiState = MutableStateFlow(UiStateLogin())
        val uistate: StateFlow<UiStateLogin> = _uiState.asStateFlow()

        fun onNombreChange(nombre: String){
            _uiState.value = _uiState.value.copy(nombre = nombre)
        }
        fun onPrecioChange(numero: String){
            _uiState.value = _uiState.value.copy(numero = numero)
        }

        fun onDescripcionChange(nacionalidad: String){
            _uiState.value = _uiState.value.copy(nacionalidad = nacionalidad)
        }

        fun onImagenChange(imagen: String){
            _uiState.value = _uiState.value.copy(imagen = imagen)
        }


        fun getJugador() {
            jogadorCollection.addSnapshotListener { snapshot, _ ->
                if (snapshot != null) {
                    val lista = snapshot.documents.mapNotNull {
                        it.toObject(Jugador::class.java)?.copy(id = it.id)
                    }
                    _jugador.value = lista
                }
            }
        }
        fun deleteProducto(id: String) {
            jogadorCollection.document(id).delete()
        }
    }
}