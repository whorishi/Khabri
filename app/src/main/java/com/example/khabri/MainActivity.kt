package com.example.khabri

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.khabri.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity(), NewsItemClicked{
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(LayoutInflater.from(this))
        setContentView(binding.root)

        binding.recyclerView.layoutManager = LinearLayoutManager(this)
        val items = fetchData()
        val adapter: NewsListAdapter = NewsListAdapter(items,this)
        binding.recyclerView.adapter = adapter
    }

    private fun fetchData():ArrayList<String>
    {
        val list = ArrayList<String>()
        for(i in 0 until 100)
        {
            list.add("Item $i")
        }
        return list;
    }

    override fun onItemClicked(item: String) {
        Toast.makeText(this, "clicked on $item", Toast.LENGTH_SHORT).show()
    }
}