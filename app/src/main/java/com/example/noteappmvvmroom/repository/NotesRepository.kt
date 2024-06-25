package com.example.noteappmvvmroom.repository

import androidx.lifecycle.LiveData
import com.example.noteappmvvmroom.Dao.NotesDao
import com.example.noteappmvvmroom.model.Notes

class NotesRepository(private val dao: NotesDao) {

    fun getAllNotes(): LiveData<List<Notes>> {
        return dao.getNotes()
    }

    fun insertNotes(notes: Notes) {
        dao.insertNotes(notes)
    }

    fun deleteNotes(id: Int) {
        dao.deleteNotes(id)
    }

    fun updateNotes(notes: Notes) {
        dao.updateNotes(notes)
    }
}