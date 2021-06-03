package com.example.cupcake.model

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class OrderViewModel : ViewModel() {

    /**
     * 數量
     */
    private val _quantity = MutableLiveData<Int>(0)
    val quantity: LiveData<Int> = _quantity

    /**
     * 口味
     */
    private val _flavor = MutableLiveData<String>("")
    val flavor: LiveData<String> = _flavor

    /**
     * 取貨日期
     */
    private val _date = MutableLiveData<String>("")
    val date: LiveData<String> = _date

    /**
     * 價格
     */
    private val _price = MutableLiveData<Double>(0.0)
    val price: LiveData<Double> = _price

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
}