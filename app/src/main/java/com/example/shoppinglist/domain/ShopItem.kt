package com.example.shoppinglist.domain

/**
 * Модель представлящия элемент в спике покупок
 *@property name - Заголовок
 *@property count - Количество
 *@property enabled - Активный/Неактивный
 *@property id - ID
 */
data class ShopItem(
    val name: String,
    val count: Int,
    val enabled: Boolean,
    var id: Int = UNDEFINED_ID
){
    companion object{
        const val UNDEFINED_ID = -1
    }
}
