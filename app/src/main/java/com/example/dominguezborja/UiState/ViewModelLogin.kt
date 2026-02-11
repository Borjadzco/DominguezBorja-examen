package com.example.dominguezborja.UiState

import androidx.lifecycle.ViewModel
import com.google.firebase.auth.FirebaseAuth
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow

class ViewModelLogin: ViewModel(){

    private val auth = FirebaseAuth.getInstance()
    private val _uiState = MutableStateFlow(UiStateLogin())
    val uiState: StateFlow<UiStateLogin> = _uiState.asStateFlow()

    fun onEmailChange(email : String){
        _uiState.value = _uiState.value.copy(email = email)
    }

    fun onContraseña(conrtaseña: String){
        _uiState.value = _uiState.value.copy(contraseña = conrtaseña)
    }

    fun login(
        onSuccess: () -> Unit,
        onError: (String) -> Unit
    ) {
        val email = _uiState.value.email
        val password = _uiState.value.contraseña
        auth.signInWithEmailAndPassword(email, password)
            .addOnSuccessListener { onSuccess() }
            .addOnFailureListener {
                onError(it.message ?: "Error al iniciar sesión")
            }
    }
}