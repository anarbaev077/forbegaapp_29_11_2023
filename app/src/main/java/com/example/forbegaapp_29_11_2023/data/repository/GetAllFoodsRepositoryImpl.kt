package com.example.forbegaapp_29_11_2023.data.repository

import com.example.forbegaapp_29_11_2023.data.fake_data.foodFakeDatas
import com.example.forbegaapp_29_11_2023.data.models.FoodModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class GetAllFoodsRepositoryImpl : GetAllFoodsRepository {

    override suspend fun getAllFoodsAsync(): List<FoodModel> =
        withContext(Dispatchers.IO) {
            foodFakeDatas()
        }

    override fun getAllFoods(): List<FoodModel> = foodFakeDatas()
}
