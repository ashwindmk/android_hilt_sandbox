package com.ashwin.android.hiltsandbox.di

import android.content.Context
import com.ashwin.android.hiltsandbox.data.AuthRepository
import com.ashwin.android.hiltsandbox.data.AuthService
import com.ashwin.android.hiltsandbox.data.UserRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Named
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class AppModule {
    @Provides
    @Singleton
    @Named("app_name")
    fun provideAppName() = "Hilt Sandbox"

    @Provides
    @Singleton
    fun provideAuthRepository(@ApplicationContext context: Context): AuthRepository {
        return AuthRepository(context)
    }

    @Provides
    @Singleton
    fun provideUserRepository() = UserRepository()

    @Provides
    @Singleton
    fun provideAuthService(authRepository: AuthRepository, userRepository: UserRepository): AuthService {
        return AuthService(authRepository, userRepository)
    }
}
