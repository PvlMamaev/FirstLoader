package com.example.firstloader

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

class MainActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.calculator)

        val edittext_first = findViewById<EditText>(R.id.edittext_first)
        val edittext_second = findViewById<EditText>(R.id.edittext_second)
        val textview_main = findViewById<TextView>(R.id.textview_main)
        val button_main = findViewById<Button>(R.id.button_main)

        button_main.setOnClickListener {
            val sum =
                edittext_first.text.toString().toInt() + edittext_second.text.toString().toInt()
            textview_main.text = sum.toString()
        }
    }

    override fun onSaveInstanceState(outState: Bundle) {

        val textview_main = findViewById<TextView>(R.id.textview_main)

        outState.putString("KEY", textview_main.text.toString())
        super.onSaveInstanceState(outState)
    }

    override fun onRestoreInstanceState(savedInstanceState: Bundle) {

        val textview_main = findViewById<TextView>(R.id.textview_main)

        textview_main.text = savedInstanceState.getString("KEY")
        super.onRestoreInstanceState(savedInstanceState)
    }
}
