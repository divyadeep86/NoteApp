package com.vh.noteapplication.di

import android.app.Application
import androidx.room.Room
import com.vh.noteapplication.data.NoteDao
import com.vh.noteapplication.data.NoteDatabase
import com.vh.noteapplication.data.NoteRepository
import com.vh.noteapplication.domain.DeleteNoteUseCase
import com.vh.noteapplication.domain.GetNotesUseCase
import com.vh.noteapplication.domain.InsertNoteUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule  {
    
    
    @Provides
    @Singleton
    fun provideDatabase(app: Application): NoteDatabase {
        return Room.databaseBuilder(app, NoteDatabase::class.java, "notes_db").build()
    }
    
    @Provides
    @Singleton
    fun provideNoteDao(db: NoteDatabase): NoteDao {
        return db.noteDao()
    }
    
    @Provides
    @Singleton
    fun provideRepository(noteDao: NoteDao): NoteRepository {
        return NoteRepository(noteDao)
    }
    
    @Provides
    @Singleton
    fun provideDeleteNoteUseCase(noteRepository: NoteRepository): DeleteNoteUseCase {
        return DeleteNoteUseCase(noteRepository)
    }
    
    @Provides
    @Singleton
    fun provideGetNoteUseCase(noteRepository: NoteRepository): GetNotesUseCase {
        return GetNotesUseCase(noteRepository)
    }
    @Provides
    @Singleton
    fun provideInsertUseCase(noteRepository: NoteRepository): InsertNoteUseCase {
        return InsertNoteUseCase(noteRepository)
    }
}