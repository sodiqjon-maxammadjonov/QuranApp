package com.example.quranapp.domain.usecase.locale

import com.example.quranapp.data.repository.LocalizationRepository
import javax.inject.Inject

class SetAppLanguageUseCase @Inject constructor(
    private val repository: LocalizationRepository
) {
    suspend operator fun invoke(languageCode: String) {
        repository.setAppLanguage(languageCode)
    }
}