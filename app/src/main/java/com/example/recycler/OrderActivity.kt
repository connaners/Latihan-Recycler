package com.example.recycler

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.ActionBar
import kotlinx.android.synthetic.main.activity_order.*
import kotlinx.android.synthetic.main.item_layout.*

class OrderActivity : AppCompatActivity() {
    var totHarga:Int = 0
    var minteger:Int = 0
    var MIN_NUMBER = 0
    var MAX_NUMBER = 99

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_order)

        val actionBar : ActionBar? = supportActionBar
        actionBar!!.setDisplayHomeAsUpEnabled(true)
        actionBar!!.setDisplayShowHomeEnabled(true)

        var intent = intent
        val aSepatu = intent.getStringExtra("pSepatu")
        val aDesc = intent.getStringExtra("pDesc")
        val aHarga = intent.getIntExtra("pHarga", 0)
        val aImg = intent.getIntExtra("pImg", 0)

        val jmlord = findViewById<TextView>(R.id.JmlOrd)


        actionBar.setTitle("Order "+aSepatu)
        SepatuOrd.text = aSepatu
        descOrd.text = aDesc
        hargaOrd.text = aHarga.toString()
        imageOrd.setImageResource(aImg)

        fun display(number: Int){
            val displayInteger = findViewById<View>(
                R.id.JmlOrd) as TextView
            displayInteger.text = "" + number

            totHarga = hargaOrd.text.toString().toInt() * displayInteger.text.toString().toInt()
            TotHarOrd.text = totHarga.toString()
        }

        decreaseOrd.setOnClickListener(){
            if(minteger == MIN_NUMBER){
                minteger = 0
            } else{
                minteger = minteger - 1
                display(minteger)
            }
        }

        increaseOrd.setOnClickListener(){
            minteger = minteger + 1
            display(minteger)
        }
        OrderLagi.setOnClickListener(){
            onBackPressed()
        }
        Bayar.setOnClickListener(){
            val intent = Intent(applicationContext, ActivityBayar::class.java)
            val getjml = jmlord.text.toString()
            val gethrg = totHarga.toString()

            intent.putExtra("S_Name", aSepatu)
            intent.putExtra("jml", getjml)
            intent.putExtra("harga", gethrg)
            startActivity(intent)
            true
        }
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }
}