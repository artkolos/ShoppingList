package com.example.shoppinglist.presentation

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.shoppinglist.R
import androidx.recyclerview.widget.*
import com.example.shoppinglist.domain.ShopItem

class ShopListAdapter : ListAdapter<ShopItem, ShopItemViewHolder>(ShopItemDiffCallback()) {

    var onShopItemLongClickListener:((ShopItem) -> Unit)? = null

    var onShopItemClickListener: ((ShopItem) -> Unit)? = null




    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ShopItemViewHolder {
        val layoutId = when(viewType){
            LAYOUT_ENABLED -> R.layout.item_shop_enabled
            LAYOUT_DISABLED -> R.layout.item_shop_disabled
            else -> throw java.lang.RuntimeException("Unknown view type: $viewType")
        }
        val view =
            LayoutInflater.from(parent.context).inflate(layoutId, parent, false)
        return ShopItemViewHolder(view)
    }

    override fun onBindViewHolder(holder: ShopItemViewHolder, position: Int) {
        val shopItem = getItem(position)
        holder.tvName.text = shopItem.name
        holder.tvCount.text = shopItem.count.toString()
        holder.itemView.setOnLongClickListener {
            onShopItemLongClickListener?.invoke(shopItem)
            true
        }
        holder.itemView.setOnClickListener {
            onShopItemClickListener?.invoke(shopItem)
        }
    }

    override fun getItemViewType(position: Int): Int {
        val shopItem = getItem(position)
        return if (shopItem.enabled){
            LAYOUT_ENABLED
        }else {
            LAYOUT_DISABLED
        }
    }

    companion object{
        const val LAYOUT_ENABLED = 0
        const val LAYOUT_DISABLED = -1
        const val MAX_POOL_SIZE = 20
    }
}