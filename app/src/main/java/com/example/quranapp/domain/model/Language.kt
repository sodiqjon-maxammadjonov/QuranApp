package com.example.quranapp.domain.model

data class Language(
    val code: String,
    val displayName: String,
    val isSystemDefault: Boolean = false
)