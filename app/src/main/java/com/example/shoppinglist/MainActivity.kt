package com.example.shoppinglist

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.ItemTouchHelper
import androidx.recyclerview.widget.RecyclerView
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
            adapter.submitList(it)
        })
    }

    private fun setupRecyclerView(){
        val rvShopList = findViewById<RecyclerView>(R.id.rcView)
        adapter = ShopListAdapter()
        rvShopList.adapter = adapter
        rvShopList.recycledViewPool.setMaxRecycledViews(ShopListAdapter.LAYOUT_ENABLED, ShopListAdapter.MAX_POOL_SIZE)
        rvShopList.recycledViewPool.setMaxRecycledViews(ShopListAdapter.LAYOUT_DISABLED, ShopListAdapter.MAX_POOL_SIZE)
        setupLongClickListener()
        setupOnClickListener()
        setupSwipeListener(rvShopList)
    }

    private fun setupSwipeListener(rvShopList: RecyclerView) {
        val itemTouchHelper = ItemTouchHelper(object : ItemTouchHelper.SimpleCallback(
            0,
            ItemTouchHelper.LEFT or ItemTouchHelper.RIGHT
        ) {
            override fun onMove(
                recyclerView: RecyclerView,
                viewHolder: RecyclerView.ViewHolder,
                target: RecyclerView.ViewHolder
            ): Boolean {
                return false
            }

            override fun onSwiped(viewHolder: RecyclerView.ViewHolder, direction: Int) {
                val position = viewHolder.adapterPosition
                val itemShop = adapter.currentList[viewHolder.adapterPosition]
                viewModel.deleteItemShopList(itemShop)
            }
        })
        itemTouchHelper.attachToRecyclerView(rvShopList)
    }

    private fun setupOnClickListener() {
        adapter.onShopItemClickListener = {
            Log.d("MyLog", "Click shop item")
        }
    }

    private fun setupLongClickListener() {
        adapter.onShopItemLongClickListener = {
            viewModel.changeEnabledState(it)
        }
    }
}