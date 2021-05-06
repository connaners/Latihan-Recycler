package com.example.recycler

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class ActivityBayar : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_bayar)

        supportActionBar!!.setTitle("Shop List")
        supportActionBar!!.setDisplayHomeAsUpEnabled(true)

        val intent = intent
        val sname = intent.getStringExtra("S_Name")
        val desc = intent.getStringExtra("jml")
        val harga = intent.getStringExtra("harga")

        val result = findViewById<TextView>(R.id.hasil)

        result.text = "Nama Sepatu \t\b:\t "+sname+
                "\n\nJumlah Order  \t\b:\t "+desc+
                "\n\nTotal Harga \t\t\t\b:\t "+harga

    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }
}