package com.example.quranapp.data.local

import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.booleanPreferencesKey
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.stringPreferencesKey
import androidx.datastore.preferences.preferencesDataStore
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

val Context.dataStore: DataStore<Preferences> by preferencesDataStore(name = "quran_app_settings")

class DataStoreManager(private val context: Context) {

    companion object {
        val THEME_MODE_KEY = stringPreferencesKey("theme_mode")
        val APP_LANGUAGE_KEY = stringPreferencesKey("app_language")
        val IS_FIRST_LAUNCH_KEY = booleanPreferencesKey("is_first_launch")
    }

    suspend fun saveThemeMode(themeMode: String) {
        context.dataStore.edit { preferences ->
            preferences[THEME_MODE_KEY] = themeMode
        }
    }

    fun getThemeMode(): Flow<String> {
        return context.dataStore.data.map { preferences ->
            preferences[THEME_MODE_KEY] ?: "system"
        }
    }

    suspend fun saveAppLanguage(languageCode: String) {
        context.dataStore.edit { preferences ->
            preferences[APP_LANGUAGE_KEY] = languageCode
        }
    }

    fun getAppLanguage(): Flow<String> {
        return context.dataStore.data.map { preferences ->
            preferences[APP_LANGUAGE_KEY] ?: "system"
        }
    }

    suspend fun saveFirstLaunch(isFirstLaunch: Boolean) {
        context.dataStore.edit { preferences ->
            preferences[IS_FIRST_LAUNCH_KEY] = isFirstLaunch
        }
    }

    fun getFirstLaunch(): Flow<Boolean> {
        return context.dataStore.data.map { preferences ->
            preferences[IS_FIRST_LAUNCH_KEY] ?: true
        }
    }
}