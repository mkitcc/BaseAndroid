package org.itsman.fastlibrary.ui.adapter

import android.R.attr.text
import android.graphics.Color
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import org.itsman.fastlibrary.databinding.ItemSimpleBinding

class SimpleAdapter : RecyclerView.Adapter<SimpleAdapter.SimpleViewHolder>() {

    var data = mutableListOf<String>()

    init {
        repeat(100) {
            data.add("$it+$it+$it")
        }
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int,
    ): SimpleViewHolder {
        val myView = ItemSimpleBinding.inflate(
            LayoutInflater.from(parent.context), parent, false
        )
        return SimpleViewHolder(myView.root)
    }

    override fun onBindViewHolder(
        holder: SimpleViewHolder,
        position: Int,
    ) {
        val str = data[position]
        val bind = ItemSimpleBinding.bind(holder.itemView)
        bind.tvLabel.text = str
    }

    override fun getItemCount(): Int {
        return data.size
    }


    inner class SimpleViewHolder(myView: View) : RecyclerView.ViewHolder(myView)
}