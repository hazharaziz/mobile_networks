package com.example.notesapp.observers

import com.example.notesapp.entities.Note
import com.example.notesapp.enums.Action

/**
 * Observer interface for NoteActionManager
 */
interface NoteActionObserver {
    /**
     * Called when action request was created
     * @param note Note we are doing action on
     * @param action Actual Action type
     */
    fun onAction(note: Note, action: Action)
}