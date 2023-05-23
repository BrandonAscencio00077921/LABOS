package com.bascencio.parcialprueba.ui.pet

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController
import com.bascencio.parcialprueba.R
import com.bascencio.parcialprueba.data.model.PetModel
import com.bascencio.parcialprueba.databinding.FragmentPetBinding
import com.bascencio.parcialprueba.ui.pet.PetViewModel
import com.bascencio.parcialprueba.ui.pet.patient.recyclerview.PetRecyclerViewAdapter


class PatientFragment : Fragment() {

    private lateinit var binding: FragmentPetBinding
    private val petViewModel: PetViewModel by activityViewModels {
        PetViewModel.Factory
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentPetBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setViewModel()
    }

    private fun setViewModel() {
        binding.viewmodel = petViewModel
    }


}