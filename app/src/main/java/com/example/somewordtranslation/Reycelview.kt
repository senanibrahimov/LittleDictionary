package com.example.somewordtranslation

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.somewordtranslation.databinding.RecycelRowBinding

class Reycelview(var context:Context,var arrayList: ArrayList<kelimeler>):RecyclerView.Adapter<Reycelview.viewholder>() {
    class viewholder(var binding: RecycelRowBinding):RecyclerView.ViewHolder(binding.root) {

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): viewholder {

        var binding=RecycelRowBinding.inflate(LayoutInflater.from(context),parent,false)

        return  viewholder(binding)
    }

    override fun getItemCount(): Int {
     return arrayList.size
    }

    override fun onBindViewHolder(holder: viewholder, position: Int) {
        holder.binding.textEngilsh.text=arrayList[position].ingilisce
        holder.binding.textTurkish.text=arrayList[position].turkce


        holder.binding.cardview.setOnClickListener {

            val intent=Intent(context,DetailsActivity::class.java)
              intent.putExtra("engilsh",arrayList[position].ingilisce)
              intent.putExtra("turk",arrayList[position].turkce)
             context.startActivity(intent)
        }

    }


}