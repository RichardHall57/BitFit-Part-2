package com.example.part5bitfit

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query

@Dao
interface WaterEntryDao {

    // Insert a water entry
    @Insert
    suspend fun insert(entry: WaterEntry)

    // Get all water entries
    @Query("SELECT * FROM water_entries")
    fun getAll(): LiveData<List<WaterEntry>>
}
