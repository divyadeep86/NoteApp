package com.vh.noteapplication.domain

import com.vh.noteapplication.data.NoteRepository
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class GetNotesUseCase (private val repository: NoteRepository) {
    @OptIn(ExperimentalCoroutinesApi::class)
    operator fun invoke(): Flow<List<Note>> = repository.getAllNotes().map { list-> list.map { it.toNote() } }
}