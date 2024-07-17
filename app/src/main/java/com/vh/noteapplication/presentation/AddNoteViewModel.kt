package com.vh.noteapplication.presentation

import android.util.Log
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.navigation.toRoute
import com.vh.noteapplication.data.NoteEntity
import com.vh.noteapplication.domain.InsertNoteUseCase
import com.vh.noteapplication.domain.Note
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class AddNoteViewModel @Inject constructor(private val insertNoteUseCase: InsertNoteUseCase,private val savedStateHandle: SavedStateHandle):ViewModel()
{
    var note: MutableState<Note> = mutableStateOf(Note())
    init {
       savedStateHandle.toRoute<Note>().let {
           note.value = it
        }
    }
    
    fun updateTitle(title: String) {
        note.value = note.value.copy(title = title)
    }
    fun updateContent(content: String) {
        note.value = note.value.copy(content = content)
    }
   
    fun addorUpdateNote() {
        viewModelScope.launch {
            insertNoteUseCase(note = note.value)
        }
    }
    
}