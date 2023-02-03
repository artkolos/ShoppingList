package com.example.shoppinglist.domain

class DeleteItemShopListUseCase(private val shopListRepository: ShopListRepository) {
    fun deleteItem(shopItem: ShopItem){
        shopListRepository.deleteItem(shopItem)
    }
}