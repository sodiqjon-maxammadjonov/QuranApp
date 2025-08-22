package com.example.quranapp.data.repository

import com.example.quranapp.data.local.DataStoreManager
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class ThemeRepository @Inject constructor(
    private val dataStoreManager: DataStoreManager
) {
    suspend fun setThemeMode(themeMode: String) {
        dataStoreManager.saveThemeMode(themeMode)
    }

    fun getThemeMode(): Flow<String> {
        return dataStoreManager.getThemeMode()
    }
}