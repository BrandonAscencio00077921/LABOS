package com.bascencio.parcialprueba.ui.pet

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import android.widget.RadioButton
import android.widget.RadioGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController
import com.bascencio.parcialprueba.R
import com.bascencio.parcialprueba.databinding.FragmentFormBinding

class FormFragment : Fragment() {


    private lateinit var Race: EditText
    private lateinit var Name: EditText
    private lateinit var Type: EditText
    private lateinit var Age: EditText
    private lateinit var Gener: EditText

    private lateinit var binding: FragmentFormBinding

    private val petViewModel: PetViewModel by activityViewModels {
        PetViewModel.Factory
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentFormBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setViewModel()
        observeStatus()
    }

    private fun observeStatus() {
        petViewModel.status.observe(viewLifecycleOwner){
            status -> when{
                status.equals(PetViewModel.WROG_INFORMATION)->{
                    petViewModel.clearStatus()
                }
            status.equals(PetViewModel.PET_CREATED)->{
                petViewModel.clearStatus()
                findNavController().popBackStack()
            }
            }
        }
    }

    private fun setViewModel() {
        binding.viewmodel = petViewModel
    }

}