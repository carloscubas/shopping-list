package com.example.shopping_list

import android.app.AlertDialog
import android.content.Intent
import android.os.Bundle
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.ListView
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import com.example.shopping_list.data.Item
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
        val items: List<Item>? = Application.database?.itemDao()?.getAllItems()
        val adapter = items?.let {
            ArrayAdapter(
                this,
                android.R.layout.simple_list_item_1,
                it.toTypedArray()
            )
        }
        val lista: ListView = findViewById(R.id.list)
        lista.adapter = adapter;

        lista.onItemLongClickListener = AdapterView.OnItemLongClickListener { _, _, position, _ ->
            val item:Item? = items?.get(position)
            val builder = AlertDialog.Builder(this)
            builder.setTitle("Remove Item")
            builder.setMessage("The It'll remove")
            builder.setPositiveButton("Remove") { _, _ ->
                if (item != null) {
                    Application.database?.itemDao()?.delete(item)
                    recreate()
                }
            }
            builder.setNegativeButton("Cancel") { _, _ ->
                recreate()
            }
            val dialog = builder.create()
            dialog.show()
            false
        }
    }
}

