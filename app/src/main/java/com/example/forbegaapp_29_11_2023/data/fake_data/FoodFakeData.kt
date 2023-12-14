package com.example.forbegaapp_29_11_2023.data.fake_data

import com.example.forbegaapp_29_11_2023.data.models.FoodModel

fun foodFakeDatas() = listOf<FoodModel>(
    FoodModel(
        foodName = "Cup Cake",
        foodDescription = "Flavoured cupcakes with special icing",
        foodPrice = "5",
        foodImage = "https://i.pinimg.com/originals/7e/fa/08/7efa08b597100e351e59a86eefe2b92d.jpg"
    ),
    FoodModel(
        foodName = "Donut",
        foodDescription = "Flavoured cupcakes with special icing",
        foodPrice = "3",
        foodImage = "https://celes.club/pictures/uploads/posts/2023-06/1686123628_celes-club-p-ponchik-narisovannii-risunok-12.jpg"
    ),
    FoodModel(
        foodName = "Macaron",
        foodDescription = "Flavoured cupcakes with special icing",
        foodPrice = "6",
        foodImage = "https://www.pngmart.com/files/22/Macaron-PNG-Isolated-Free-Download.png"
    ),
)