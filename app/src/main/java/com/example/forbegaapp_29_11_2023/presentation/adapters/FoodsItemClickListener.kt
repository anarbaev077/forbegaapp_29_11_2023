package com.example.forbegaapp_29_11_2023.presentation.adapters

import com.example.forbegaapp_29_11_2023.data.models.FoodModel

interface FoodsItemClickListener {
    fun onFoodItemClick(foodModel: FoodModel)
}