package com.example.quranapp.data.repository

import com.example.quranapp.data.local.DataStoreManager
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class LocalizationRepository @Inject constructor(
    private val dataStoreManager: DataStoreManager
) {
    suspend fun setAppLanguage(languageCode: String) {
        dataStoreManager.saveAppLanguage(languageCode)
    }

    fun getAppLanguage(): Flow<String> {
        return dataStoreManager.getAppLanguage()
    }
}