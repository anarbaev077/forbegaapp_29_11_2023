package com.example.forbegaapp_29_11_2023.presentation.on_boarding_screen

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.forbegaapp_29_11_2023.R
import com.example.forbegaapp_29_11_2023.databinding.FragmentOnBoardingScreenBinding
import com.example.forbegaapp_29_11_2023.data.preferences.UserEnteredSharedPref

class OnBoardingScreenFragment : Fragment() {

    private val binding: FragmentOnBoardingScreenBinding by lazy {
        FragmentOnBoardingScreenBinding.inflate(layoutInflater)
    }
    private val sharedPreferences: UserEnteredSharedPref by lazy {
        UserEnteredSharedPref(requireContext())
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? = binding.root

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        if (sharedPreferences.getIsUserFirstSign()) {
            findNavController().navigate(
                R.id.action_onBoardingScreenFragment_to_mainScreenFragment
            )
        } else {
            binding.getStartedBtn.setOnClickListener {
                sharedPreferences.setUserFirstSign(true)
                findNavController().navigate(
                    R.id.action_onBoardingScreenFragment_to_mainScreenFragment
                )
            }
        }
    }
}