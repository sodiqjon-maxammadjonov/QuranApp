package com.example.quranapp.domain.model

sealed class AppState {
    object Loading : AppState()
    object Ready : AppState()
    object Error : AppState()
}