package com.example.quranapp.domain.model

enum class ThemeMode(val value: String) {
    SYSTEM("system"),
    LIGHT("light"),
    DARK("dark");

    companion object {
        fun fromValue(value: String): ThemeMode {
            return ThemeMode.entries.find { it.value == value } ?: SYSTEM
        }
    }
}