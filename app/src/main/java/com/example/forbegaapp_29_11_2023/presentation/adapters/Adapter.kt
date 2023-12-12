package com.example.forbegaapp_29_11_2023.presentation.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.forbegaapp_29_11_2023.R
import com.example.forbegaapp_29_11_2023.data.models.FoodModel
import com.example.forbegaapp_29_11_2023.databinding.FoodItemOnBasketBinding

class Adapter(
    private val onDeleteClick: (index: Int) -> Unit,
) : RecyclerView.Adapter<Adapter.CartViewHolder>() {
    private var foodList = mutableListOf<FoodModel>()

    fun updateList(foodList: List<FoodModel>) {
        this.foodList.clear()
        this.foodList.addAll(foodList)
        notifyDataSetChanged()
    }

    inner class CartViewHolder(private val binding: FoodItemOnBasketBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(foodModel: FoodModel) {
            binding.cupCakeTv.text = foodModel.foodName
            binding.flavouredTv.text = foodModel.foodDescription
            binding.priceOfCupCake.text = "${foodModel.foodPrice}$"
            binding.deleteMd.setOnClickListener {
                onDeleteClick.invoke(foodList.indexOf(foodModel))
            }
            Glide.with(binding.root)
                .load(foodModel.foodImage)
                .into(binding.foodPhoto)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Adapter.CartViewHolder {
        val binding = FoodItemOnBasketBinding.bind(
            LayoutInflater.from(parent.context).inflate(R.layout.food_item_on_basket, parent, false)
        )
        return CartViewHolder(binding)
    }

    override fun onBindViewHolder(holder: CartViewHolder, position: Int) {
        holder.bind(foodList[position])
    }

    override fun getItemCount() = foodList.size
}