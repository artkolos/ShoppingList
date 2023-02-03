package com.example.shoppinglist.domain

class AddShopListItemUseCase(private val shopListRepository: ShopListRepository) {
    fun addShopListItem(shopItem: ShopItem){
        shopListRepository.addShopListItem(shopItem)
    }
}