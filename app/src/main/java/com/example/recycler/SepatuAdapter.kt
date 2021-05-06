package com.example.recycler

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.view.menu.ActionMenuItemView
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.item_layout.view.*

class SepatuAdapter (val arrayList: ArrayList<SepatuModel>, val context: Context):
        RecyclerView.Adapter<SepatuAdapter.ViewHolder>(){

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){

        fun bindItems(model: SepatuModel){
            itemView.NamaSepatu.text = model.nmSepatu
            itemView.DescSepatu.text = model.descSepatu
            itemView.HargaSepatu.text = model.hargaSepatu.toString()
            itemView.imgSepatu.setImageResource(model.imgSepatu)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {

        val v = LayoutInflater.from(parent.context).inflate(R.layout.item_layout, parent, false)
        return ViewHolder(v)
    }

    override fun getItemCount(): Int {

        return arrayList.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        holder.bindItems(arrayList[position])

        holder.itemView.setOnClickListener(){
            val model = arrayList.get(position)

            var gSepatu : String = model.nmSepatu
            var gDesc : String = model.descSepatu
            var gHarga : Int = model.hargaSepatu.toString().toInt()
            var gImg : Int = model.imgSepatu

            val intent = Intent(context, OrderActivity::class.java)
            intent.putExtra("pSepatu", gSepatu)
            intent.putExtra("pDesc", gDesc)
            intent.putExtra("pHarga", gHarga)
            intent.putExtra("pImg", gImg)

            context.startActivity(intent)
        }
    }
}