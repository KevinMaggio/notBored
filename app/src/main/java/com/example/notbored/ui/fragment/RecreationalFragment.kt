package com.example.notbored.ui.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import com.example.notbored.R
import com.example.notbored.databinding.FragmentRecreationalBinding
import com.example.notbored.ui.viewModel.ActivitiesViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class RecreationalFragment : Fragment() {

    lateinit var binding: FragmentRecreationalBinding
    private val activitiesViewModel by activityViewModels<ActivitiesViewModel>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentRecreationalBinding.inflate(inflater, container, false)

        activitiesViewModel.liveResponseActivity.observe(viewLifecycleOwner,{
            binding.tvRecreationalType.text=it.type
            binding.tvResultPrice.text=convertPrice(it.price)
            binding.tvResultParticipants.text=it.participants.toString()
            binding.tvActivity.text=it.activity
        })

        binding.btTryAnother.setOnClickListener {
            activitiesViewModel.getActivities(getType(),getParticipants())
        }
        binding.ibCancel.setOnClickListener {
            findNavController().popBackStack()
        }


        return binding.root
    }
    fun getType(): String {
        return arguments?.get("type").toString()
    }
    fun getParticipants(): String {
        return arguments?.get("participants").toString()
    }
    fun convertPrice(priceDouble: Double): String{
        return when (priceDouble) {
            0.0 -> "Free"
            in 0.1..0.3   -> "Low"
            in 0.4..0.6 -> "Medium"
            else -> "High"
        }
    }

}