package com.example.shoppinglist.presentation

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.shoppinglist.data.ShopListRepositoryImpl
import com.example.shoppinglist.domain.*

/**
 * Класс который поставляет данные на главный экран
 * <img src="C:\Users\artem\AndroidStudioProjects\ShoppingList\doc\html\images\mvvm.png">
 */
class MainViewModel(application: Application):  AndroidViewModel(application){

    private val repository = ShopListRepositoryImpl

    private val getShopListUseCase = GetShopListUseCase(repository)
    private val deleteItemShopListUseCase = DeleteItemShopListUseCase(repository)
    private val editItemShopListUseCase = EditItemShopListUseCase(repository)

    val shopList = getShopListUseCase.getShopList()

    fun deleteItemShopList(shopItem: ShopItem){
        deleteItemShopListUseCase.deleteItem(shopItem)
    }

    fun changeEnabledState(shopItem: ShopItem){
        val newItem = shopItem.copy(enabled = !shopItem.enabled)
        editItemShopListUseCase.editItem(newItem)
    }

}