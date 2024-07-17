package com.vh.noteapplication.domain

import com.vh.noteapplication.data.NoteEntity
import com.vh.noteapplication.data.NoteRepository

class DeleteNoteUseCase(private val repository: NoteRepository) {
    
    suspend operator fun invoke(note: Note) = repository.delete(note.toNoteEntity())
}