package com.example.shopping_list.data

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "Items")
data class Item(
    @PrimaryKey(autoGenerate = true)
    val id: Long = 0,
    val title: String
) {
    override fun toString(): String {
        return title
    }
}