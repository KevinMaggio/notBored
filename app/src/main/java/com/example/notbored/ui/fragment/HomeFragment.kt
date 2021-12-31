package com.example.notbored.ui.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.notbored.R
import com.example.notbored.databinding.FragmentHomeBinding


class HomeFragment : Fragment() {

    lateinit var binding : FragmentHomeBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding= FragmentHomeBinding.inflate(inflater, container, false)


        binding.btActivities.setOnClickListener {
            findNavController().navigate(R.id.action_homeFragment_to_activitiesFragment)
        }

        binding.twTermsAndConditions.setOnClickListener {
            findNavController().navigate(R.id.action_homeFragment_to_conditionFragment)
        }

        return binding.root
    }

}