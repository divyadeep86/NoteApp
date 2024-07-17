package com.vh.noteapplication.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.vh.noteapplication.data.NoteEntity
import com.vh.noteapplication.domain.DeleteNoteUseCase
import com.vh.noteapplication.domain.GetNotesUseCase
import com.vh.noteapplication.domain.Note
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class NoteViewModel @Inject constructor(
    private val getNotesUseCase: GetNotesUseCase,
    
    private val deleteNoteUseCase: DeleteNoteUseCase
) : ViewModel()
{
    val notes: StateFlow<List<Note>> = getNotesUseCase().stateIn(viewModelScope, SharingStarted.Lazily, emptyList())
    
    fun deleteNote(note: Note) {
        viewModelScope.launch {
            deleteNoteUseCase(note)
        }
    }
}