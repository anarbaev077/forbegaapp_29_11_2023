package com.example.forbegaapp_29_11_2023.presentation.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.forbegaapp_29_11_2023.R
import com.example.forbegaapp_29_11_2023.data.models.FoodModel
import com.example.forbegaapp_29_11_2023.databinding.FoodItemBinding
import com.example.forbegaapp_29_11_2023.presentation.details_screen.BasketFragment

class FoodAdapter(
    private val listener: FoodsItemClickListener
) : RecyclerView.Adapter<FoodAdapter.FoodsViewHolder>() {

    private var foodList = mutableListOf<FoodModel>()

    fun updateList(foodList: List<FoodModel>) {
        this.foodList.clear()
        this.foodList.addAll(foodList)
        notifyDataSetChanged()
    }

    inner class FoodsViewHolder(private val binding: FoodItemBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(foodModel: FoodModel) {
            binding.cupCakeTv.text = foodModel.foodName
            binding.flavouredTv.text = foodModel.foodDescription
            binding.priceOfCupCake.text = "${foodModel.foodPrice}$"
            binding.itemCard.setOnClickListener {
                listener.onFoodItemClick(foodModel)
            }
            Glide.with(binding.root)
                .load(foodModel.foodImage)
                .into(binding.foodPhoto)
        }
    }

    override fun onCreateViewHolder(
        parent: ViewGroup, viewType: Int,
    ): FoodsViewHolder {
        val binding = FoodItemBinding.bind(
            LayoutInflater.from(parent.context).inflate(R.layout.food_item, parent, false)
        )
        return FoodsViewHolder(binding)
    }

    override fun getItemCount(): Int = foodList.size

    override fun onBindViewHolder(
        holder: FoodsViewHolder,
        position: Int,
    ) {
        holder.bind(foodList[position])
    }
}
