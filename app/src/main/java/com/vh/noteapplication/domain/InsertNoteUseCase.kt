package com.vh.noteapplication.domain

import com.vh.noteapplication.data.NoteEntity
import com.vh.noteapplication.data.NoteRepository

class InsertNoteUseCase (private val repository: NoteRepository) {
    
    suspend operator fun invoke(note: Note) = repository.insert(note.toNoteEntity())
}