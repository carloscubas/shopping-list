package com.example.shopping_list

import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar

class NewItem : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_new_item)

        val toolbar = findViewById<Toolbar>(R.id.toolbar_child)
        toolbar.title = "Shopping List"

        val button: Button = findViewById(R.id.button)
        button.setOnClickListener {
            finish()
        }
    }
}