package com.example.shoppinglist.domain

import androidx.lifecycle.LiveData
/**
 * Use-case отвечающий за получние списка элементлв
 * @property shopListRepository ShopListRepository из которого вызывается метод для получения списка элементов
 */
class GetShopListUseCase(private val shopListRepository: ShopListRepository) {
    fun getShopList(): LiveData<List<ShopItem>>{
        return shopListRepository.getShopList()
    }
}