package com.example.forbegaapp_29_11_2023.data.preferences

import android.content.Context
import com.example.forbegaapp_29_11_2023.data.models.FoodModel
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import java.lang.reflect.Type

private const val FOOD_SHARED_PREFERENCES_KEY = "FOOD_SHARED_PREFERENCES_KEY"
private const val FOOD_PREF_KEY = "FOOD_PREF_KEY"

class FoodCartSharedPref(
    private val context: Context
) {
    private val sharedPreferences = context.getSharedPreferences(
        FOOD_SHARED_PREFERENCES_KEY, Context.MODE_PRIVATE
    )

    private val gson = Gson()

    fun saveFood(foodModel: FoodModel) {
        val notes = getAllSavedFood().toMutableList()
        notes.add(0, foodModel)
        val notesGson = Gson().toJson(notes)
        sharedPreferences
            .edit()
            .putString(FOOD_PREF_KEY, notesGson)
            .apply()
    }

    fun getAllSavedFood(): List<FoodModel> {
        val json = sharedPreferences.getString(FOOD_PREF_KEY, null)
        val type: Type = object : TypeToken<ArrayList<FoodModel?>?>() {}.type
        val foodList = gson.fromJson<List<FoodModel>>(json, type)
        return foodList ?: emptyList()
    }

    fun deleteNoteAtIndex(index: Int) {
        val getAllFoods = getAllSavedFood().toMutableList()
        if (index in 0 until getAllFoods.size) {
            getAllFoods.removeAt(index)
            val foodGsonString = Gson(). toJson(getAllFoods)
            sharedPreferences.edit().putString(FOOD_PREF_KEY, foodGsonString).apply()
        }
    }

    fun deleteAllSavedFood() = sharedPreferences
        .edit()
        .clear()
        .commit()
}
