package com.ashwin.android.hiltsandbox.di

import android.content.Context
import com.ashwin.android.hiltsandbox.data.PostRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityComponent
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.android.scopes.ActivityScoped

@Module
@InstallIn(ActivityComponent::class)
class HomeActivityModule {
    /**
     * Hilt automatically uses this if injected in any Activity
     * No need to add @Named annotation
     */
    @Provides
    @ActivityScoped
    fun providePostRepository(@ApplicationContext context: Context) = PostRepository(context)
}
