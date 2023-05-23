package com.bascencio.parcialprueba.ui.pet.patient.recyclerview

import android.widget.ExpandableListView.OnChildClickListener
import androidx.recyclerview.widget.RecyclerView
import com.bascencio.parcialprueba.data.model.PetModel
import com.bascencio.parcialprueba.databinding.FragmentFormBinding
import com.bascencio.parcialprueba.databinding.PetItemBinding

class PetRecyclerViewHolder(private val binding: PetItemBinding) : RecyclerView.ViewHolder(binding.root){

    fun bind(pet: PetModel, clickListener: (PetModel)-> Unit){
        binding.nombrePet.text = pet.name
        binding.agePet.text = pet.age

        binding.petItemCardView.setOnClickListener{
            clickListener(pet)
        }
    }

}