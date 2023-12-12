package com.example.forbegaapp_29_11_2023.presentation.details_screen

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.forbegaapp_29_11_2023.data.models.FoodModel
import com.example.forbegaapp_29_11_2023.data.preferences.FoodCartSharedPref
import com.example.forbegaapp_29_11_2023.databinding.FragmentBasketBinding
import com.example.forbegaapp_29_11_2023.presentation.adapters.Adapter
import com.example.forbegaapp_29_11_2023.presentation.adapters.FoodAdapter
import com.example.forbegaapp_29_11_2023.presentation.adapters.FoodsItemClickListener
import com.google.android.material.dialog.MaterialAlertDialogBuilder
import com.google.android.material.snackbar.Snackbar

class BasketFragment : Fragment(), FoodsItemClickListener {

    private val binding: FragmentBasketBinding by lazy {
        FragmentBasketBinding.inflate(layoutInflater)
    }
    private val sharedPreferences: FoodCartSharedPref by lazy {
        FoodCartSharedPref(requireContext())
    }
    private val adapter: Adapter by lazy {
        Adapter(
            onDeleteClick = {index ->
                sharedPreferences.deleteNoteAtIndex(index)
                setupViews()
            }
        )
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupViews()
        binding.backCvFragment.setOnClickListener {
            findNavController().popBackStack()
        }
        binding.deleteMd.setOnClickListener{
            showConfirmDeleteFoodDialog().apply {}
        }
    }

    private fun setupViews() {
        val savedFoodList = sharedPreferences.getAllSavedFood()
        adapter.updateList(savedFoodList)
        binding.foodsRv.adapter = adapter
    }

    private fun showConfirmDeleteFoodDialog() {
        val alertDialog = MaterialAlertDialogBuilder(requireContext())
        alertDialog.setMessage("Do you want delete all sweets?")
        alertDialog.setPositiveButton("Yes") { dialog, _ ->
            deleteAllSavedFoods()
            dialog.dismiss()
        }
        alertDialog.setNegativeButton("Cancel") { dialog, _ ->
            dialog.dismiss()
        }
        alertDialog.create().show()
    }

    private fun deleteAllSavedFoods() {
        sharedPreferences.deleteAllSavedFood()
        adapter.updateList(emptyList())
    }


    override fun onFoodItemClick(foodModel: FoodModel) {

    }

    private fun setupClickListener() = binding.apply {
        deleteMd.setOnClickListener {
            showConfirmDeleteFoodDialog()
        }
    }
}
