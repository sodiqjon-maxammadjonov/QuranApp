package com.example.quranapp.presentation.main

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.quranapp.domain.usecase.locale.GetAppLanguageUseCase
import com.example.quranapp.domain.usecase.theme.GetThemeUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.combine
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    getAppLanguageUseCase: GetAppLanguageUseCase,
    getThemeUseCase: GetThemeUseCase
) : ViewModel() {

    private val _state = MutableStateFlow(MainState())
    val state: StateFlow<MainState> = _state

    init {
        combine(
            getAppLanguageUseCase(),
            getThemeUseCase()
        ) { language, theme ->
            MainState(
                currentLanguage = language,
                currentTheme = theme
            )
        }.onEach { newState ->
            _state.value = newState
        }.launchIn(viewModelScope)
    }
}

data class MainState(
    val currentLanguage: String = "system",
    val currentTheme: String = "system"
)