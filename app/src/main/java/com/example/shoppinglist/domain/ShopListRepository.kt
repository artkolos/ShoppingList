package com.example.shoppinglist.domain

import androidx.lifecycle.LiveData

/**
 * Интерфейс описывающий поведение ShopListRepositoryImpl
 */
interface ShopListRepository {
    /**
     * @param[shopItem]  - добавляемый объект
     * @method
     */
    fun addShopListItem(shopItem: ShopItem)

    /**
     * @param[shopItem] - удаляемый объект
     * @method
     */
    fun deleteItem(shopItem: ShopItem)

    /**
     * Редактировать объект
     * @param[shopItem] - редактируемый объект
     * @method
     */
    fun editItem(shopItem: ShopItem)

    /**
     * Получить объект по id
     * @param[id] - id объекта
     * @method
     */
    fun getItemById(id: Int): ShopItem

    /**
     * Получить спиоск объектов
     * @method
     */
    fun getShopList(): LiveData<List<ShopItem>>

}