package com.example.shanonim.kotlin_databinding_listview.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import com.example.shanonim.kotlin_databinding_listview.databinding.ItemListViewBinding
import com.example.shanonim.kotlin_databinding_listview.model.KemonoModel

class KemonoAdapter(private val context: Context) : BaseAdapter() {
    var kemonoFriends: List<KemonoModel> = emptyList()

    override fun getCount(): Int = kemonoFriends.size

    override fun getItem(position: Int): Any? = kemonoFriends[position]

    override fun getItemId(position: Int): Long = 0

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        val binding: ItemListViewBinding
        if (convertView == null) {
            binding = ItemListViewBinding.inflate(LayoutInflater.from(context), parent, false)
            binding.root.tag = binding
        } else {
            binding = convertView.tag as ItemListViewBinding
        }
        binding?.kemonoFriends = getItem(position) as KemonoModel

        return binding.root
    }
}
