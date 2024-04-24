package com.example.shoppinglist.domain

/**
 * Use-case отвечающий за редактирование эелмента
 * @property shopListRepository ShopListRepository из которого вызывается метод для редактирования элемента
 */
class EditItemShopListUseCase(private val shopListRepository: ShopListRepository) {
    fun editItem(shopItem: ShopItem){
        shopListRepository.editItem(shopItem)
    }
}