package com.example.noteappmvvmroom.repository

import androidx.lifecycle.LiveData
import com.example.noteappmvvmroom.Dao.NotesDao
import com.example.noteappmvvmroom.model.Notes

class NotesRepository(private val dao: NotesDao) {

    fun getAllNotes(): LiveData<List<Notes>> = dao.getNotes()

    fun getLowNotes(): LiveData<List<Notes>> = dao.getLowNotes()

    fun getMediumNotes(): LiveData<List<Notes>> = dao.getMediumNotes()

    fun getHighNotes(): LiveData<List<Notes>> = dao.getHighNotes()


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