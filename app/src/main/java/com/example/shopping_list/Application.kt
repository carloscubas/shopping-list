package com.example.shopping_list

import android.app.Application
import com.example.shopping_list.data.ItemDatabase

class Application : Application() {

    companion object {
        var database: ItemDatabase? = null
    }

    override fun onCreate() {
        super.onCreate()
        database = ItemDatabase.getDatabase(this)
    }
}
