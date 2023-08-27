package com.season.winter.composenoteapp.di

import android.content.Context
import com.season.winter.composenoteapp.data.NoteDatabaseDao
import com.season.winter.composenoteapp.database.NoteDatabase
import com.season.winter.composenoteapp.repository.NoteRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
object NoteRepositoryModule {

    @Singleton
    @Provides
    fun provideNoteRepository(
        noteDatabaseDao: NoteDatabaseDao
    ): NoteRepository {
        return NoteRepository(noteDatabaseDao)
    }

    @Singleton
    @Provides
    fun provideNoteDatabase(
        @ApplicationContext context: Context
    ): NoteDatabase {
        return NoteDatabase.getInstance(context)
    }

    @Singleton
    @Provides
    fun provideNoteDatabaseDao(database: NoteDatabase): NoteDatabaseDao {
        return database.noteDao()
    }
}