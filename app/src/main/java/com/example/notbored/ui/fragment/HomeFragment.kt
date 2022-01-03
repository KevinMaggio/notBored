package com.example.notbored.ui.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.ArrayAdapter
import androidx.navigation.fragment.findNavController
import com.example.notbored.R
import com.example.notbored.databinding.FragmentHomeBinding


class HomeFragment : Fragment() {


    lateinit var binding: FragmentHomeBinding
    val list = listOf<String>("1", "2", "3", "4", "5", "6", "7", "8")
    lateinit var temp: Any

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentHomeBinding.inflate(inflater, container, false)

        binding.spParticipants.adapter = ArrayAdapter<String>(requireContext(), android.R.layout.simple_spinner_dropdown_item, list)

        binding.btActivities.setOnClickListener {
            var bundle = Bundle()
            bundle.putString("participants", temp.toString() )
            findNavController().navigate(R.id.action_homeFragment_to_activitiesFragment, bundle)
        }

        binding.tvTermsAndConditions.setOnClickListener {
            findNavController().navigate(R.id.action_homeFragment_to_conditionFragment)
        }

        binding.spParticipants.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(p0: AdapterView<*>?, p1: View?, p2: Int, p3: Long) {
                temp = p0?.getItemAtPosition(p2)!!

            }

            override fun onNothingSelected(p0: AdapterView<*>?) {
                TODO("Not yet implemented")
            }

        }



        return binding.root
    }

}