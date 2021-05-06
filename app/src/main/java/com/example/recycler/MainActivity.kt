package com.example.recycler

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val arrayItem = ArrayList<SepatuModel>()
        arrayItem.add(SepatuModel("Adidas", "Adidas memiliki huruf awalan A",
            R.drawable.brodo, 500000))
        arrayItem.add(SepatuModel("Brodo", "Brodo memiliki huruf awalan B",
            R.drawable.convers, 200000))
        arrayItem.add(SepatuModel("Diadora", "Diadora memiliki huruf awalan D",
            R.drawable.diadora, 300000))
        arrayItem.add(SepatuModel("League", "League memiliki huruf awalan L",
            R.drawable.league, 600000))
        arrayItem.add(SepatuModel("New Balance", "New Balance disingkat NB",
            R.drawable.newbalance, 99700000))
        arrayItem.add(SepatuModel("Nike", "Nike memiliki huruf awalan N",
            R.drawable.nike, 900000))
        arrayItem.add(SepatuModel("Puma", "Puma memiliki huruf awalan P",
            R.drawable.puma, 100000))
        arrayItem.add(SepatuModel("Recook", "Recook memiliki huruf awalan R",
            R.drawable.recook, 600000))
        arrayItem.add(SepatuModel("Vans", "Vans memiliki huruf awalan V",
            R.drawable.vans, 200000))
        arrayItem.add(SepatuModel("Wakai", "Wakai memiliki huruf awalan W",
            R.drawable.wakai, 6500000))

        var myAdapter = SepatuAdapter(arrayItem, this)

        RV_Sepatu.layoutManager = LinearLayoutManager(this)
        RV_Sepatu.adapter = myAdapter
    }
}