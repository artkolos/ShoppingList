package com.example.shoppinglist.data

import com.example.shoppinglist.domain.ShopItem
import com.example.shoppinglist.domain.ShopListRepository

object ShopListRepositoryImp : ShopListRepository {

    private val shopList = mutableListOf<ShopItem>()


    private var autoIncrementId = 0

    override fun addShopListItem(shopItem: ShopItem) {
        if (shopItem.id == ShopItem.UNDEFINED_ID){
            shopItem.id = autoIncrementId++
        }
        shopList.add(shopItem)
    }

    override fun deleteItem(shopItem: ShopItem) {
        shopList.remove(shopItem)
    }

    override fun editItem(shopItem: ShopItem) {
        val oldElement = getItemById(shopItem.id)
        shopList.remove(oldElement)
        addShopListItem(shopItem)
    }

    override fun getItemById(id: Int): ShopItem {
        return shopList.find { shopItem -> shopItem.id == id }
            ?: throw java.lang.RuntimeException("Element id $id not found")
    }

    override fun getShopList(): List<ShopItem> {
        return shopList.toList()
    }
}