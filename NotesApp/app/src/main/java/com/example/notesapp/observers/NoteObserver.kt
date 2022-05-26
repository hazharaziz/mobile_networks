package com.example.notesapp.observers

import com.example.notesapp.entities.Note

/**
 * Standard observer interface for Notes
 */
interface NoteObserver {
    /**
     * Called on notes update
     * @param mNotes Array of notes
     */
    fun onNotesChanged(mNotes: Array<Note>?)
}