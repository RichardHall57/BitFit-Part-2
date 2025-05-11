package com.example.part5bitfit

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class WaterViewModel(application: Application) : AndroidViewModel(application) {
    private val dao = AppDatabase.getDatabase(application).waterEntryDao()
    val allEntries: LiveData<List<WaterEntry>> = dao.getAll()

    private val _selectedEntry = MutableLiveData<WaterEntry?>()
    val selectedEntry: LiveData<WaterEntry?> get() = _selectedEntry

    fun insert(entry: WaterEntry) {
        viewModelScope.launch(Dispatchers.IO) {
            dao.insert(entry)
        }
    }

    fun selectEntry(entry: WaterEntry) {
        _selectedEntry.value = entry
    }

    fun clearSelectedEntry() {
        _selectedEntry.value = null
    }
}

