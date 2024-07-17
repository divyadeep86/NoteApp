package com.vh.noteapplication.presentation

import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.toRoute
import com.vh.noteapplication.data.NoteEntity
import com.vh.noteapplication.domain.Note
import kotlinx.serialization.Serializable

@Composable
fun AppNavigation(navHostController: NavHostController) {
    
    NavHost(navController = navHostController, startDestination = NoteList) {
        composable<NoteList> {
            val noteViewModel: NoteViewModel = hiltViewModel()
            NoteListScreen(
                noteList = noteViewModel.notes.collectAsState().value,
                editNote = { note -> navHostController.navigate(note) },
                addNote = { navHostController.navigate(Note()) },
                deleteNote = noteViewModel::deleteNote
            )
        }
        composable<Note> {
            val addNoteViewModel: AddNoteViewModel = hiltViewModel()
            AddOrUpdateNoteScreen(note = addNoteViewModel.note.value,
                addOrUpdate = addNoteViewModel::addorUpdateNote,
                updateTitle = addNoteViewModel::updateTitle,
                updateContent = addNoteViewModel::updateContent,
                onBackPress = { navHostController.navigateUp() })
        }
        
    }
    
}

@Serializable
object NoteList

