package com.example.shoestore_starter.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.shoestore_starter.R
import com.example.shoestore_starter.models.Shoe

class RV_Shoe_Adapter(var lista: ArrayList<Shoe>) : RecyclerView.Adapter<RV_Shoe_Adapter.ViewHolder>() {
//    private lateinit var lista : MutableList<Shoe>

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_shoe, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val i = lista[position]

        holder.name.text = "${holder.name.text} ${i.name}"
        holder.company.text = "${holder.company.text} ${i.company}"
        holder.size.text = "${holder.size.text} ${i.size}"
        holder.description.text = "${holder.description.text}\n${i.description}"
    }

    override fun getItemCount(): Int = lista.size


    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var name: TextView = itemView.findViewById(R.id.tv_name)
        var company: TextView = itemView.findViewById(R.id.tv_Company)
        var size: TextView = itemView.findViewById(R.id.tv_size)
        var description: TextView = itemView.findViewById(R.id.tv_description)

    }
}




//var name: TextView
//var company: TextView
//var size: TextView
//var description: TextView
//
//init {
//    name = itemView.findViewById<TextView>(R.id.tv_name)
//    company = itemView.findViewById<TextView>(R.id.tv_Company)
//    size = itemView.findViewById<TextView>(R.id.tv_size)
//    description = itemView.findViewById<TextView>(R.id.tv_description)
//}