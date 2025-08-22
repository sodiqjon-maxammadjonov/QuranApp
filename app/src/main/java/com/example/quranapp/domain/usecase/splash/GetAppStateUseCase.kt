package com.example.quranapp.domain.usecase.splash

import com.example.quranapp.data.repository.AppRepository
import com.example.quranapp.domain.model.AppState
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetAppStateUseCase @Inject constructor(
    private val repository: AppRepository
) {
    operator fun invoke(): Flow<AppState> {
        return repository.getAppState()
    }
}