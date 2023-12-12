package com.example.forbegaapp_29_11_2023.data.preferences

import android.content.Context
import com.example.forbegaapp_29_11_2023.data.models.FoodModel
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import java.lang.reflect.Type


private const val SHARED_PREFERENCES_KEY = "SHARED_PREFERENCES_KEY"
private const val USER_SIGN_SHAREDPREF_KEY = "USER_SIGN_SHAREDPREF_KEY"


class UserEnteredSharedPref(

    private val context: Context,
) {

    private val sharedPreferences = context.getSharedPreferences(
         "ShoppingCart", Context.MODE_PRIVATE
    )
    private val editor = sharedPreferences.edit()


    private fun saveCart(cart: List<String>) {
        val cartJson = Gson().toJson(cart)
        editor.putString("cart", cartJson)
        editor.apply()
    }

    fun getCart(): MutableList<String> {
        val cartJson = sharedPreferences.getString("cart", "[]")
        return Gson().fromJson(cartJson, object : TypeToken<MutableList<String>>() {}.type)
    }

    fun getAllFoods(): List<FoodModel> {
        val gson = Gson()
        val json = sharedPreferences.getString(USER_SIGN_SHAREDPREF_KEY, null)
        val type: Type = object : TypeToken<ArrayList<FoodModel?>?>() {}.type
        val noteList = gson.fromJson<List<FoodModel>>(json, type)
        return noteList ?: emptyList()
    }

    fun getIsUserFirstSign(): Boolean {
        return sharedPreferences.getBoolean(USER_SIGN_SHAREDPREF_KEY, false)
    }


    fun setUserFirstSign(userFirstSign: Boolean) {
        sharedPreferences.edit().putBoolean(USER_SIGN_SHAREDPREF_KEY, userFirstSign).apply()

    }

    fun saveFood(foodModel: FoodModel) {
        val foods = getAllFoods().toMutableList()
        foods.add(0, foodModel)
        val foodsGson = Gson().toJson(foods)
        sharedPreferences
            .edit()
            .putString(USER_SIGN_SHAREDPREF_KEY, foodsGson)
            .apply()
    }

}