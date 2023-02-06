package com.example.shoppinglist.data

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.shoppinglist.domain.ShopItem
import com.example.shoppinglist.domain.ShopListRepository

object ShopListRepositoryImpl : ShopListRepository {

    private val shopList = mutableListOf<ShopItem>()

    private val liveData = MutableLiveData<List<ShopItem>>()

    private var autoIncrementId = 0

    init {
        for (i in 0 until 10){
            val item = ShopItem("Name$i", i, true)
            addShopListItem(item)
        }
    }
    override fun addShopListItem(shopItem: ShopItem) {
        if (shopItem.id == ShopItem.UNDEFINED_ID){
            shopItem.id = autoIncrementId++
        }
        shopList.add(shopItem)
        updateShopList()
    }

    override fun deleteItem(shopItem: ShopItem) {
        shopList.remove(shopItem)
        updateShopList()
    }

    override fun editItem(shopItem: ShopItem) {
        val oldElement = getItemById(shopItem.id)
        shopList.remove(oldElement)
        addShopListItem(shopItem)
        updateShopList()
    }

    override fun getItemById(id: Int): ShopItem {
        return shopList.find { shopItem -> shopItem.id == id }
            ?: throw java.lang.RuntimeException("Element id $id not found")
    }

    override fun getShopList(): LiveData<List<ShopItem>> {
        return liveData
    }

    fun updateShopList(){
        liveData.value = shopList.toList()
    }
}