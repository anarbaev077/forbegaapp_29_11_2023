package com.example.forbegaapp_29_11_2023.data.fake_data

import com.example.forbegaapp_29_11_2023.data.models.FoodModel

fun foodFakeDatas() = listOf<FoodModel>(
    FoodModel(
        foodName = "Cup Cake",
        foodDescription = "Flavoured cupcakes with special icing",
        foodPrice = "5",
        foodImage = "https://avatars.mds.yandex.net/i?id=0f0f5d10de8fd1048e782cd7f749e1c9f674bfb6-5219488-images-thumbs&n=13"
    ),
    FoodModel(
        foodName = "Donut",
        foodDescription = "Flavoured cupcakes with special icing",
        foodPrice = "3",
        foodImage = "https://compote.slate.com/images/5be21b55-d861-4986-9ffd-7f09474cc859.jpg?crop=3000%2C2000%2Cx0%2Cy0"
    ),
    FoodModel(
        foodName = "Macaron",
        foodDescription = "Flavoured cupcakes with special icing",
        foodPrice = "6",
        foodImage = "https://avatars.mds.yandex.net/i?id=a364a87e5692833e0f917944f1bd53ee1dd17ce7-11380860-images-thumbs&n=13"
    ),
)