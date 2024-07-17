package com.vh.noteapplication.data

class NoteRepository constructor(private val noteDao: NoteDao) {
    
     fun getAllNotes() = noteDao.getAllNotes()
     suspend fun insert(noteEntity: NoteEntity) = noteDao.insert(noteEntity)
     suspend fun delete(noteEntity: NoteEntity) = noteDao.delete(noteEntity)
}