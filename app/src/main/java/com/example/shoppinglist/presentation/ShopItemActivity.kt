package com.example.shoppinglist.presentation

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.widget.Button
import android.widget.EditText
import androidx.lifecycle.ViewModelProvider
import com.example.shoppinglist.R
import com.example.shoppinglist.domain.ShopItem
import com.google.android.material.textfield.TextInputLayout

class ShopItemActivity : AppCompatActivity() {

//    private lateinit var tilName: TextInputLayout
//    private lateinit var tilCount: TextInputLayout
//
//    private lateinit var etName: EditText
//    private lateinit var etCount: EditText
//
//    private lateinit var buttonSave: Button
//
//    private var screenMode = MODE_UNKNOWN
//    private var shopItemID = ShopItem.UNDEFINED_ID

    private lateinit var viewModel: ShopItemViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_shop_item)
//        parseIntent()
//        viewModel = ViewModelProvider(this)[ShopItemViewModel::class.java]
//        initViews()
//        addTextChangeListeners()
//        launchRightMode()
//        observeViewModel()
    }



//    private fun observeViewModel(){
//        viewModel.errorInputCount.observe(this) {
//            val message = if (it) {
//                getString(R.string.error_input_count)
//            } else {
//                null
//            }
//            tilCount.error = message
//        }
//
//        viewModel.errorInputName.observe(this) {
//            val message = if (it) {
//                getString(R.string.error_input_name)
//            } else {
//                null
//            }
//            tilName.error = message
//        }
//        viewModel.isClose.observe(this) {
//            finish()
//        }
//    }
//    private fun launchRightMode(){
//        when (screenMode) {
//            MODE_EDIT -> launchEditMode()
//            MODE_ADD -> launchAddMode()
//        }
//    }
//    private fun addTextChangeListeners(){
//        etName.addTextChangedListener(object : TextWatcher {
//            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
//
//            }
//
//            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
//                viewModel.resetErrorInputName()
//            }
//
//            override fun afterTextChanged(p0: Editable?) {
//
//            }
//        })
//
//        etCount.addTextChangedListener(object : TextWatcher {
//            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
//
//            }
//
//            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
//                viewModel.resetErrorInputCount()
//            }
//
//            override fun afterTextChanged(p0: Editable?) {
//
//            }
//        })
//    }
//
//    private fun launchEditMode() {
//        viewModel.getShopItem(shopItemID)
//
//        viewModel.shopItem.observe(this) {
//            etName.setText(it.name)
//            etCount.setText(it.count.toString())
//        }
//        buttonSave.setOnClickListener {
//            viewModel.editShopItem(etName.text.trim().toString(), etCount.text.trim().toString())
//
//        }
//    }
//
//    private fun launchAddMode() {
//        buttonSave.setOnClickListener {
//            viewModel.addShopItem(etName.text.trim().toString(), etCount.text.trim().toString())
//        }
//    }
//
//    private fun parseIntent() {
//        if (!intent.hasExtra(EXTRA_SCREEN_MODE)) {
//            throw java.lang.RuntimeException("Param screen mode is absent")
//        }
//        val mode = intent.getStringExtra(EXTRA_SCREEN_MODE)
//
//        if (mode != MODE_ADD && mode != MODE_EDIT) {
//            throw java.lang.RuntimeException("Unknown screen mode $mode")
//        }
//        screenMode = mode
//        if (screenMode == MODE_EDIT) {
//            if (!intent.hasExtra(EXTRA_SHOP_ITEM_ID)) {
//                throw java.lang.RuntimeException("Param shop item id is absent")
//            }
//            shopItemID = intent.getIntExtra(EXTRA_SHOP_ITEM_ID, -1)
//        }
//    }
//
//    private fun initViews() {
//        tilName = findViewById(R.id.til_name)
//        tilCount = findViewById(R.id.til_count)
//
//        etCount = findViewById(R.id.et_count)
//        etName = findViewById(R.id.et_name)
//
//        buttonSave = findViewById(R.id.save_button)
//    }
//
    companion object {
        private const val EXTRA_SCREEN_MODE = "extra_mode"
        private const val EXTRA_SHOP_ITEM_ID = "extra_shop_item_id"
        private const val MODE_EDIT = "mode_edit"
        private const val MODE_ADD = "mode_add"
        private const val MODE_UNKNOWN = ""

        fun newIntentAddItem(context: Context): Intent {
            val intent = Intent(context, ShopItemActivity::class.java)
            intent.putExtra(EXTRA_SCREEN_MODE, MODE_ADD)
            return intent
        }

        fun newIntentEditItem(context: Context, id: Int): Intent {
            val intent = Intent(context, ShopItemActivity::class.java)
            intent.putExtra(EXTRA_SCREEN_MODE, MODE_EDIT)
            intent.putExtra(EXTRA_SHOP_ITEM_ID, id)
            return intent
        }
    }
}