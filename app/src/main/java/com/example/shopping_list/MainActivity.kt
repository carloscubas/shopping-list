package com.example.shopping_list

import android.content.Intent
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.ListView
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import com.google.android.material.floatingactionbutton.FloatingActionButton

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val toolbar = findViewById<Toolbar>(R.id.toolbar)
        toolbar.title = "Shopping List"

        val fab: FloatingActionButton = findViewById(R.id.fab)
        fab.setOnClickListener {
            val intent = Intent(this, NewItem::class.java)
            startActivity(intent)
        }
    }

    override fun onResume() {
        super.onResume()
        val items = arrayOf("Banana", "Tomato", "Apple")
        val adapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, items)
        val list: ListView = findViewById(R.id.list)
        list.adapter = adapter;
        }
}

