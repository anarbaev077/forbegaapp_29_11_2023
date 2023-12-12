package com.example.forbegaapp_29_11_2023.data.repository

import com.example.forbegaapp_29_11_2023.data.models.FoodModel

interface GetAllFoodsRepository {
    suspend fun getAllFoodsAsync(): List<FoodModel>
    fun getAllFoods(): List<FoodModel>
}