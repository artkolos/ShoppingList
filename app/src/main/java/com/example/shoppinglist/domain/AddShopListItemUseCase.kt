package com.example.shoppinglist.domain

/**
 * Use-case отвечающий за добаваление эелмента
 * @property shopListRepository ShopListRepository из которого вызывается метод для добавления элемента
 */
class AddShopListItemUseCase(private val shopListRepository: ShopListRepository) {
    fun addShopListItem(shopItem: ShopItem){
        shopListRepository.addShopListItem(shopItem)
    }
}