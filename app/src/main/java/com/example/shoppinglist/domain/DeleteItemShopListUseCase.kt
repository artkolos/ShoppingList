package com.example.shoppinglist.domain

/**
 * Use-case отвечающий за удаления элемента
 * @property shopListRepository ShopListRepository из которого вызывается метод для удаления элемента
 */
class DeleteItemShopListUseCase(private val shopListRepository: ShopListRepository) {
    fun deleteItem(shopItem: ShopItem){
        shopListRepository.deleteItem(shopItem)
    }
}