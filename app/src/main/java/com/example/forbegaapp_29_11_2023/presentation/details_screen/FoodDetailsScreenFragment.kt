package com.example.forbegaapp_29_11_2023.presentation.details_screen

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.setFragmentResult
import androidx.navigation.fragment.findNavController
import com.bumptech.glide.Glide
import com.example.forbegaapp_29_11_2023.data.models.FoodModel
import com.example.forbegaapp_29_11_2023.data.preferences.FoodCartSharedPref
import com.example.forbegaapp_29_11_2023.data.preferences.UserEnteredSharedPref
import com.example.forbegaapp_29_11_2023.databinding.FragmentFoodDetailsScreenBinding
import com.example.forbegaapp_29_11_2023.presentation.main_screen.MainScreenFragment
import com.example.forbegaapp_29_11_2023.presentation.main_screen.MainScreenFragment.Companion.FOOD_KEY
import com.google.android.material.snackbar.Snackbar

class FoodDetailsScreenFragment : Fragment() {

    private val binding: FragmentFoodDetailsScreenBinding by lazy {
        FragmentFoodDetailsScreenBinding.inflate(layoutInflater)
    }

    private val sharedPreferences: FoodCartSharedPref by lazy {
        FoodCartSharedPref(requireContext())
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View = binding.root

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val foodModel = arguments?.getSerializable(FOOD_KEY) as? FoodModel
        foodModel?.let {
            setupView(it)
            setupClickLIsteners(foodModel)
        }

        binding.backCv.setOnClickListener {
            findNavController().popBackStack()
        }
    }

    private fun setupView(foodModel: FoodModel) {
        binding.apply {
            Glide.with(requireActivity())
                .load(foodModel.foodImage)
                .into(ivFood)
            tvFoodTitle.text = foodModel.foodName
            tvFoodDescription.text = foodModel.foodDescription
            tvFoodPrice.text = "${foodModel.foodPrice}$"
        }
    }
    private fun setupClickLIsteners(foodModel: FoodModel) {
        binding.saveBtn.setOnClickListener {
            sharedPreferences.saveFood(foodModel)
            Snackbar.make(
                requireView(),
                "Added to cart successfully",
                Snackbar.LENGTH_SHORT
            ).show()
        }
    }
}
