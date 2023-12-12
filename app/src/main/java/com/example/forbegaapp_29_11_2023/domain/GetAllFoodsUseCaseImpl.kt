package com.example.forbegaapp_29_11_2023.domain

import com.example.forbegaapp_29_11_2023.data.models.FoodModel
import com.example.forbegaapp_29_11_2023.data.repository.GetAllFoodsRepository
import com.example.forbegaapp_29_11_2023.data.repository.GetAllFoodsRepositoryImpl

class GetAllFoodsUseCaseImpl : GetAllFoodsUseCase {

    private val foodsRepository = GetAllFoodsRepositoryImpl()

    override suspend fun getAllFoods(): List<FoodModel> {
        return foodsRepository.getAllFoodsAsync()
    }
}