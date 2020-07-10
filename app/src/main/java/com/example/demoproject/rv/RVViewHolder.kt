package com.example.demoproject.rv

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.ViewParent
import androidx.recyclerview.widget.RecyclerView
import com.example.demoproject.Item
import com.example.demoproject.R
import kotlinx.android.extensions.LayoutContainer
import kotlinx.android.synthetic.main.item_view.*

class RVViewHolder(override val containerView: View, private val clickLambda: (Item) -> Unit) :
    RecyclerView.ViewHolder(containerView), LayoutContainer {

    fun bind(item: Item) {
        tvName.text = item.name
        tvNumber.text = item.number.toString()
        btnToast.setOnClickListener { clickLambda(item) }
    }

    companion object {
        fun create(parent: ViewGroup, clickLambda: (Item) -> Unit) = RVViewHolder(
            LayoutInflater.from(parent.context).inflate(
                R.layout.item_view,
                parent,
                false
            ), clickLambda
        )
    }
}