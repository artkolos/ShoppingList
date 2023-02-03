package com.example.shoppinglist.domain

class EditItemShopListUseCase(private val shopListRepository: ShopListRepository) {
    fun editItem(shopItem: ShopItem){
        shopListRepository.editItem(shopItem)
    }
}