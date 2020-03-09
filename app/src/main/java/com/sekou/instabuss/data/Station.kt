package com.example.instabus.data

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.io.Serializable

@Entity(tableName = "stations")
data class Station (
    @PrimaryKey(autoGenerate = true)
    val stationId: Int,
    val strNameStation: String?
) : Serializable