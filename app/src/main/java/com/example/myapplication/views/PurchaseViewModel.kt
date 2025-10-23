package com.example.myapplication.views
import androidx.lifecycle.ViewModel
import androidx.compose.runtime.mutableStateListOf
import com.example.myapplication.Data.Purchase

class PurchaseViewModel : ViewModel() {

    val purchases = mutableStateListOf<Purchase>()

    fun addPurchase(purchase: Purchase) {
        purchases.add(purchase)
    }

    fun clearPurchases() {
        purchases.clear()
    }
}
