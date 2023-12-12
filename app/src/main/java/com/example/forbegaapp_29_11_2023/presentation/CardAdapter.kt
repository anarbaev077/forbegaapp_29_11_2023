package com.example.forbegaapp_29_11_2023.presentation

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.forbegaapp_29_11_2023.R
import com.example.forbegaapp_29_11_2023.data.models.FoodModel
import com.example.forbegaapp_29_11_2023.databinding.FoodItemBinding
import com.example.forbegaapp_29_11_2023.databinding.FoodItemOnBasketBinding

class CardAdapter(
    private val context: Context

) : RecyclerView.Adapter<CardAdapter.CartViewHolder>() {

    private var foodList = mutableListOf<FoodModel>()

    inner class CartViewHolder(private val binding: FoodItemOnBasketBinding)
        :RecyclerView.ViewHolder(binding.root){
        fun bind (foodModel: FoodModel){
            binding.cupCakeTv.text = foodModel.foodName
            binding.flavouredTv.text = foodModel.foodDescription
            binding.priceOfCupCake.text = "${foodModel.foodPrice}$"
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CartViewHolder {
        val binding = FoodItemOnBasketBinding.bind(
            LayoutInflater.from(parent.context).inflate(R.layout.food_item_on_basket, parent, false)
        )
        return CartViewHolder(binding)
    }

    override fun getItemCount() = foodList.size

    override fun onBindViewHolder(holder: CartViewHolder, position: Int) {
        holder.bind(foodList[position])
    }

}