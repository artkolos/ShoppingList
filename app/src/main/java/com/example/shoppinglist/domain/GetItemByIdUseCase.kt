package com.example.shoppinglist.domain

/**
 * Use-case отвечающий за поиск эелмента по id
 * @property shopListRepository ShopListRepository из которого вызывается метод для поиска элемента по id
 */
class GetItemByIdUseCase(private val shopListRepository: ShopListRepository) {
    fun getItemById(id: Int): ShopItem{
        return shopListRepository.getItemById(id)
    }
}