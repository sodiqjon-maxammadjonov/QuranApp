package com.example.quranapp.domain.usecase.locale

import com.example.quranapp.data.repository.LocalizationRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetAppLanguageUseCase @Inject constructor(
    private val repository: LocalizationRepository
) {
    operator fun invoke(): Flow<String> {
        return repository.getAppLanguage()
    }
}