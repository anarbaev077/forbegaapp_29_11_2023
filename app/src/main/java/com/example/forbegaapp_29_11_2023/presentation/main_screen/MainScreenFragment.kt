package com.example.forbegaapp_29_11_2023.presentation.main_screen

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.widget.SearchView
import androidx.core.os.bundleOf
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.example.forbegaapp_29_11_2023.R
import com.example.forbegaapp_29_11_2023.data.fake_data.foodFakeDatas
import com.example.forbegaapp_29_11_2023.data.models.FoodModel
import com.example.forbegaapp_29_11_2023.databinding.FragmentMainScreenBinding
import com.example.forbegaapp_29_11_2023.presentation.adapters.FoodAdapter
import com.example.forbegaapp_29_11_2023.presentation.adapters.FoodsItemClickListener

class MainScreenFragment : Fragment(), FoodsItemClickListener {

    private val binding: FragmentMainScreenBinding by lazy {
        FragmentMainScreenBinding.inflate(layoutInflater)
    }

    private val adapter: FoodAdapter by lazy {
        FoodAdapter(this)
    }

    private lateinit var viewModel: MainScreenViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View = binding.root

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel = ViewModelProvider(
            this,
            ViewModelProvider.NewInstanceFactory()
        )[MainScreenViewModel::class.java]
        setupStatusColors()
        setupDataListeners()
        binding.basketCv.setOnClickListener {
            findNavController().navigate(R.id.action_mainScreenFragment_to_basketFragment)
        }
    }

    private fun setupDataListeners() {
        viewModel.foodLiveData.observe(viewLifecycleOwner) { foodList ->
            adapter.updateList(foodList)
            binding.foodsRv.adapter = adapter
        }
            binding.searchCv.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
                override fun onQueryTextChange(p0: String?): Boolean {
                    return false
                }

                override fun onQueryTextSubmit(text: String?): Boolean {
                    text?.let {
                        filterNotes(it)
                    }
                    return true
                }
            })
    }

    private fun setupStatusColors() {
        requireActivity().window.statusBarColor =
            resources.getColor(R.color.onboarding_btn_background)
        requireActivity().window.navigationBarColor = resources.getColor(R.color.white)
    }

    override fun onFoodItemClick(foodModel: FoodModel) {
        findNavController().navigate(
            R.id.action_mainScreenFragment_to_foodDetailsScreenFragment,
            bundleOf(FOOD_KEY to foodModel)
        )
    }

    companion object {
        const val FOOD_KEY = "FOOD_KEY"
    }

    private fun filterNotes(title: String) {
        val filterNote = foodFakeDatas().filter { name ->
            name.foodName.contains(title, ignoreCase = false)
        }
        adapter.updateList(filterNote)
    }
}