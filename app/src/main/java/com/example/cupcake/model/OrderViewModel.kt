package com.example.cupcake.model

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import java.text.SimpleDateFormat
import java.util.*

class OrderViewModel : ViewModel() {

    /**
     * 數量
     */
    private val _quantity = MutableLiveData<Int>()
    val quantity: LiveData<Int> = _quantity

    /**
     * 口味
     */
    private val _flavor = MutableLiveData<String>()
    val flavor: LiveData<String> = _flavor

    /**
     * 取貨日期
     */
    private val _date = MutableLiveData<String>()
    val date: LiveData<String> = _date

    /**
     * 價格
     */
    private val _price = MutableLiveData<Double>()
    val price: LiveData<Double> = _price

    /**
     * 日期選項
     */
    val dateOptions = getPickupOptions()

    init {
        resetOrder()
    }

    /**
     * 設定數量
     * The default visibility modifier in Kotlin is public.
     */
    fun setQuantity(numberCupcakes: Int) {
        _quantity.value = numberCupcakes
    }

    fun setFlavor(desiredFlavor: String) {
        _flavor.value = desiredFlavor
    }

    fun setDate(pickupDate: String) {
        _date.value = pickupDate
    }

    /**
     * 檢查該訂單是否有選口味了
     */
    fun hasNoFlavorSet(): Boolean {
        return _flavor.value.isNullOrEmpty()
    }

    /**
     * 取得取貨日期選項
     */
    private fun getPickupOptions(): List<String> {
        val options = mutableListOf<String>()
        val formatter = SimpleDateFormat("E MMM d", Locale.getDefault())
        val calendar = Calendar.getInstance()

        // Create a list of dates starting with the current date and the following 3 dates
        repeat(4) {
            options.add(formatter.format(calendar.time))
            calendar.add(Calendar.DATE, 1)
        }
        return options
    }

    /**
     * 重設訂單
     */
    fun resetOrder() {
        _quantity.value = 0
        _flavor.value = ""
        _date.value = dateOptions[0]
        _price.value = 0.0
    }
}