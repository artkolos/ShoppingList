package com.example.shoppinglist

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.widget.LinearLayout
import android.widget.TextView
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.RecyclerView
import com.example.shoppinglist.domain.ShopItem
import com.example.shoppinglist.presentation.MainViewModel
import com.example.shoppinglist.presentation.ShopListAdapter

class MainActivity : AppCompatActivity() {
    private lateinit var viewModel: MainViewModel
    private lateinit var adapter: ShopListAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setupRecyclerView()
        viewModel = ViewModelProvider(this)[MainViewModel::class.java]
        viewModel.shopList.observe(this, Observer {
            adapter.shopList = it
        })

    }

    private fun setupRecyclerView(){
        val rvShopList = findViewById<RecyclerView>(R.id.rcView)
        adapter = ShopListAdapter()
        rvShopList.adapter = adapter
        rvShopList.recycledViewPool.setMaxRecycledViews(ShopListAdapter.LAYOUT_ENABLED, ShopListAdapter.MAX_POOL_SIZE)
        rvShopList.recycledViewPool.setMaxRecycledViews(ShopListAdapter.LAYOUT_DISABLED, ShopListAdapter.MAX_POOL_SIZE)
        adapter.onShopItemLongClickListener = {
            viewModel.changeEnabledState(it)
        }
        adapter.onShopItemClickListener = {
            Log.d("MyLog", "Click shop item")
        }
    }
}