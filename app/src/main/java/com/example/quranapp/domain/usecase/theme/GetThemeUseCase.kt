package com.example.quranapp.domain.usecase.theme

import com.example.quranapp.data.repository.ThemeRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetThemeUseCase @Inject constructor(
    private val repository: ThemeRepository
) {
    operator fun invoke(): Flow<String> {
        return repository.getThemeMode()
    }
}