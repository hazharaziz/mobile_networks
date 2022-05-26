package com.example.notesapp.interfaces

import me.argraur.notes.observers.NoteActionObserver

/**
 * Observer manager
 */
interface NoteActionObserverManager {
    /**
     * Registers observer
     * @param observer NoteObserver type to-be-registered
     */
    fun registerObserver(observer: NoteActionObserver)

    /**
     * Removes observer
     * @param observer NoteObserver type to-be-removed
     */
    fun removeObserver(observer: NoteActionObserver)

    /**
     * Notifies all observers about update
     */
    fun notifyObserver()
}