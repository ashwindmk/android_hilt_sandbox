package com.ashwin.android.hiltsandbox.di

import android.content.Context
import com.ashwin.android.hiltsandbox.data.PostRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.android.scopes.ViewModelScoped

@Module
@InstallIn(ViewModelComponent::class)
class HomeModule {
    @Provides
    @ViewModelScoped
    fun providePostRepository(@ApplicationContext context: Context) = PostRepository(context)
}
