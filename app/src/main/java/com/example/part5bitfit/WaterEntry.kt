package com.example.part5bitfit

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "water_entries")
data class WaterEntry(
    @PrimaryKey(autoGenerate = true) val id: Long = 0,  // Auto-generate the primary key
    val date: String,  // Date when the entry was made
    val glasses: Int   // Number of glasses consumed
)
