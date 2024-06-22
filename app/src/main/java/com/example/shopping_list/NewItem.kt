package com.example.shopping_list

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import com.example.shopping_list.data.Item

class NewItem : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_new_item)

        val toolbar = findViewById<Toolbar>(R.id.toolbar_child)
        toolbar.title = "Shopping List"

        val title: EditText = findViewById(R.id.item)

        val button: Button = findViewById(R.id.button)
        button.setOnClickListener {
            Application.database?.itemDao()?.insert(Item(title = title.text.toString()))
            finish()
        }
    }
}