package com.example.forbegaapp_29_11_2023.domain

import com.example.forbegaapp_29_11_2023.data.models.FoodModel

interface GetAllFoodsUseCase {
    suspend fun getAllFoods(): List<FoodModel>
}