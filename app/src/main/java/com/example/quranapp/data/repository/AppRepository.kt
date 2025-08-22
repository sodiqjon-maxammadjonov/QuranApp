package com.example.quranapp.data.repository

import com.example.quranapp.data.local.DataStoreManager
import com.example.quranapp.domain.model.AppState
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.firstOrNull
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class AppRepository @Inject constructor(
    private val dataStoreManager: DataStoreManager
) {
    fun getAppState(): Flow<AppState> = flow {
        emit(AppState.Loading)

        val isFirstLaunch = dataStoreManager.getFirstLaunch()
            .firstOrNull() ?: true

        if (isFirstLaunch) {
            delay(3000)
            dataStoreManager.saveFirstLaunch(false)
        } else {
            delay(1500)
        }

        emit(AppState.Ready)
    }
}