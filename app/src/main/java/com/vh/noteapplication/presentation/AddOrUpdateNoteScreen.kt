package com.vh.noteapplication.presentation

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.vh.noteapplication.data.NoteEntity
import com.vh.noteapplication.domain.Note

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AddOrUpdateNoteScreen(
    note: Note,
    updateTitle: (String) -> Unit,
    updateContent: (String) -> Unit,
    addOrUpdate: () -> Unit,
    onBackPress: () -> Unit
) {
    Scaffold(topBar = {
        TopAppBar(navigationIcon = {
            Icon(
                Icons.Default.ArrowBack, contentDescription = "back",
                modifier = Modifier.clickable(true, onClick = onBackPress))
            
        }, title = { Text("Add or updated") })
    }, floatingActionButton = {
    
    }) { paddingValue ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValue)
                .padding(16.dp),
            verticalArrangement = Arrangement.spacedBy(10.dp)
        ) {
            OutlinedTextField(
                value = note.title,
                onValueChange = updateTitle,
                label = { Text("Title") },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(bottom = 16.dp),
                shape = RoundedCornerShape(8.dp)
            )
            
            OutlinedTextField(
                value = note.content,
                onValueChange = updateContent,
                label = { Text("Description") },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(bottom = 16.dp),
                shape = RoundedCornerShape(8.dp)
            )
            
            Button(
                onClick = addOrUpdate,
                modifier = Modifier.align(Alignment.End)
            ) {
                Text("Add")
            }
        }
    }
    
}