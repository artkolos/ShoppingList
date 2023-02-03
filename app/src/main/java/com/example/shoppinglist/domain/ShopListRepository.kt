package com.example.shoppinglist.domain

interface ShopListRepository {

    fun addShopListItem(shopItem: ShopItem)

    fun deleteItem(shopItem: ShopItem)

    fun editItem(shopItem: ShopItem)

    fun getItemById(id: Int): ShopItem

    fun getShopList(): List<ShopItem>
}