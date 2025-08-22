package com.example.quranapp.domain.usecase.theme

import com.example.quranapp.data.repository.ThemeRepository
import javax.inject.Inject

class SetThemeUseCase @Inject constructor(
    private val repository: ThemeRepository
) {
    suspend operator fun invoke(themeMode: String) {
        repository.setThemeMode(themeMode)
    }
}