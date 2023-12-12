package com.example.forbegaapp_29_11_2023.presentation.main_screen

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.forbegaapp_29_11_2023.data.models.FoodModel
import com.example.forbegaapp_29_11_2023.data.repository.GetAllFoodsRepositoryImpl
import com.example.forbegaapp_29_11_2023.domain.GetAllFoodsUseCaseImpl
import kotlinx.coroutines.launch

class MainScreenViewModel : ViewModel() {

    private val getAllFoodsUseCase = GetAllFoodsUseCaseImpl()

    val foodLiveData:MutableLiveData<List<FoodModel>> = MutableLiveData()

    init {
        getAllFoods()
    }

    private fun getAllFoods() {
        viewModelScope.launch {
            val response = getAllFoodsUseCase.getAllFoods()
            foodLiveData.postValue(response)
        }
    }
}