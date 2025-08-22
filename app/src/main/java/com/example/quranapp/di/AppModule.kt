package com.example.quranapp.di

import android.content.Context
import com.example.quranapp.data.local.DataStoreManager
import com.example.quranapp.data.repository.AppRepository
import com.example.quranapp.data.repository.LocalizationRepository
import com.example.quranapp.data.repository.ThemeRepository
import com.example.quranapp.domain.usecase.locale.GetAppLanguageUseCase
import com.example.quranapp.domain.usecase.locale.SetAppLanguageUseCase
import com.example.quranapp.domain.usecase.splash.GetAppStateUseCase
import com.example.quranapp.domain.usecase.theme.GetThemeUseCase
import com.example.quranapp.domain.usecase.theme.SetThemeUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideDataStoreManager(@ApplicationContext context: Context): DataStoreManager {
        return DataStoreManager(context)
    }

    @Provides
    @Singleton
    fun provideAppRepository(dataStoreManager: DataStoreManager): AppRepository {
        return AppRepository(dataStoreManager)
    }

    @Provides
    @Singleton
    fun provideLocalizationRepository(dataStoreManager: DataStoreManager): LocalizationRepository {
        return LocalizationRepository(dataStoreManager)
    }

    @Provides
    @Singleton
    fun provideThemeRepository(dataStoreManager: DataStoreManager): ThemeRepository {
        return ThemeRepository(dataStoreManager)
    }

    @Provides
    @Singleton
    fun provideGetAppStateUseCase(repository: AppRepository): GetAppStateUseCase {
        return GetAppStateUseCase(repository)
    }

    @Provides
    @Singleton
    fun provideGetAppLanguageUseCase(repository: LocalizationRepository): GetAppLanguageUseCase {
        return GetAppLanguageUseCase(repository)
    }

    @Provides
    @Singleton
    fun provideSetAppLanguageUseCase(repository: LocalizationRepository): SetAppLanguageUseCase {
        return SetAppLanguageUseCase(repository)
    }

    @Provides
    @Singleton
    fun provideGetThemeUseCase(repository: ThemeRepository): GetThemeUseCase {
        return GetThemeUseCase(repository)
    }

    @Provides
    @Singleton
    fun provideSetThemeUseCase(repository: ThemeRepository): SetThemeUseCase {
        return SetThemeUseCase(repository)
    }
}