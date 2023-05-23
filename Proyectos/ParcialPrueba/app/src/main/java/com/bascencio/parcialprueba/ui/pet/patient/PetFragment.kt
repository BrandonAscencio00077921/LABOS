package com.bascencio.parcialprueba.ui.pet.patient

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.bascencio.parcialprueba.R
import com.bascencio.parcialprueba.data.model.PetModel
import com.bascencio.parcialprueba.databinding.FragmentPetBinding
import com.bascencio.parcialprueba.ui.pet.PetViewModel
import com.bascencio.parcialprueba.ui.pet.patient.recyclerview.PetRecyclerViewAdapter

class PetFragment : Fragment() {


    private lateinit var adapter: PetRecyclerViewAdapter
    private val petViewModel : PetViewModel by activityViewModels {
        PetViewModel.Factory
    }
    private lateinit var binding: FragmentPetBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentPetBinding.inflate(inflater, container, false)
        return binding.root
    }

    private fun showSelectedItem(pet: PetModel){
        petViewModel.setSelectedPet(pet)
        findNavController().navigate(R.id.action_petFragment_to_patientFragment)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setRecyclerView(view)

        binding.addButton.setOnClickListener {
            petViewModel.clearData()
            it.findNavController().navigate(R.id.action_petFragment_to_formFragment)
        }
    }

    private fun displayPets(){
        adapter.setData(petViewModel.getPets())
        adapter.notifyDataSetChanged()
    }

    private fun setRecyclerView(view: View) {
        binding.recyclerViewPet.layoutManager = LinearLayoutManager(view.context)

        adapter = PetRecyclerViewAdapter { selectedPet ->
            showSelectedItem(selectedPet)
        }
        binding.recyclerViewPet.adapter = adapter
        displayPets()
    }
}