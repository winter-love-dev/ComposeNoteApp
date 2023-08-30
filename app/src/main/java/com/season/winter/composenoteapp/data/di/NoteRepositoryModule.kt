package com.season.winter.composenoteapp.data.di

import android.content.Context
import com.season.winter.composenoteapp.data.NoteRepositoryImpl
import com.season.winter.composenoteapp.database.note.NoteDatabase
import com.season.winter.composenoteapp.database.note.NoteDatabaseDao
import com.season.winter.composenoteapp.domain.note.NoteRepository
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
        noteDatabaseDao: NoteDatabaseDao,
    ): NoteRepository =
        NoteRepositoryImpl(noteDatabaseDao)

    @Singleton
    @Provides
    fun provideNoteDatabase(
        @ApplicationContext context: Context,
    ): NoteDatabase =
        NoteDatabase.getInstance(context)

    @Singleton
    @Provides
    fun provideNoteDatabaseDao(
        database: NoteDatabase,
    ): NoteDatabaseDao =
        database.noteDao()
}