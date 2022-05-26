package com.example.notesapp

import android.app.Application
import com.example.notesapp.helpers.NoteManager

/**
 * Creates NoteManager instance
 */
@Suppress("Unused")
class App: Application() {
    override fun onCreate() {
        super.onCreate()
        NoteManager.getInstance(this)
    }
}