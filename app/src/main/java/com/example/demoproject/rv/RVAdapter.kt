package com.example.demoproject.rv


import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.demoproject.Item

class RVAdapter(private val dataSrc: List<Item>, private val clickLambda: (Item) -> Unit) :
    RecyclerView.Adapter<RVViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RVViewHolder =
        RVViewHolder.create(parent, clickLambda)

    override fun getItemCount(): Int = dataSrc.size

    override fun onBindViewHolder(holder: RVViewHolder, position: Int) =
        holder.bind(dataSrc[position])
}
