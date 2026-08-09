package com.example.demo_project_android.di

import com.example.demo_project_android.data.repository.AuthRepositoryImpl
import com.example.demo_project_android.data.repository.MovieRepositoryImpl
import com.example.demo_project_android.domain.repository.AuthRepository
import com.example.demo_project_android.domain.repository.MovieRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class RepositoryModule {

    @Binds
    @Singleton
    abstract fun bindMovieRepository(
        movieRepositoryImpl: MovieRepositoryImpl
    ): MovieRepository

    @Binds
    @Singleton
    abstract fun bindAuthRepository(
        authRepositoryImpl: AuthRepositoryImpl
    ): AuthRepository
}
