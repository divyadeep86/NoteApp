package com.vh.noteapplication.domain

import com.vh.noteapplication.data.NoteEntity
import kotlinx.serialization.Serializable

@Serializable
data class Note(
    val id: Int = 0,
    val title: String = "",
    val content: String = "",
)

fun NoteEntity.toNote(): Note {
    return Note(
        id = id,
        title = title,
        content = content
    )
}
fun Note.toNoteEntity(): NoteEntity {
    return NoteEntity(
        id = id,
        title = title,
        content = content,
        timestamp = System.currentTimeMillis()
    )
}