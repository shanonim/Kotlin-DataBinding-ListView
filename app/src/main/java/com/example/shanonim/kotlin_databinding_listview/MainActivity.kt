package com.example.shanonim.kotlin_databinding_listview

import android.databinding.DataBindingUtil
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.shanonim.kotlin_databinding_listview.adapter.KemonoAdapter
import com.example.shanonim.kotlin_databinding_listview.databinding.ActivityMainBinding
import com.example.shanonim.kotlin_databinding_listview.model.KemonoModel
import com.example.shanonim.kotlin_databinding_listview.model.KemonoData

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val binding : ActivityMainBinding
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        val listAdapter = KemonoAdapter(applicationContext)
        val list = mutableListOf<KemonoModel>()
        for (value in KemonoData.values()) {
            list.add(KemonoModel(value.kemonoName, value.kemonoWords))
        }
        listAdapter.kemonoFriends = list
        binding.listview.adapter = listAdapter

        binding.setOnItemClick { adapterView, view, position, l ->
            Toast.makeText(this, listAdapter.kemonoFriends[position].kemonoName, Toast.LENGTH_SHORT).show()
        }
    }
}
