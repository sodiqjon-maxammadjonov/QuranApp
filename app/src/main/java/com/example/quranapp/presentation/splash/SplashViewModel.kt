package com.example.quranapp.presentation.splash

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.quranapp.domain.model.AppState
import com.example.quranapp.domain.usecase.splash.GetAppStateUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

@HiltViewModel
class SplashViewModel @Inject constructor(
    private val getAppStateUseCase: GetAppStateUseCase
) : ViewModel() {

    private val _state = MutableStateFlow(SplashState())
    val state: StateFlow<SplashState> = _state

    init {
        loadAppState()
    }

    private fun loadAppState() {
        getAppStateUseCase().onEach { appState ->
            _state.value = _state.value.copy(
                isLoading = appState == AppState.Loading,
                appState = appState
            )
        }.launchIn(viewModelScope)
    }
}

data class SplashState(
    val isLoading: Boolean = true,
    val appState: AppState = AppState.Loading
)