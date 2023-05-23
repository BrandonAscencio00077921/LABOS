package com.bascencio.parcialprueba.ui.pet.patient.recyclerview

import android.content.DialogInterface.OnClickListener
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bascencio.parcialprueba.data.model.PetModel
import com.bascencio.parcialprueba.databinding.PetItemBinding
import java.util.ArrayList

class PetRecyclerViewAdapter (private val clickListener: (PetModel) -> Unit)
    : RecyclerView.Adapter<PetRecyclerViewHolder>() {
    private val pets = ArrayList<PetModel>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PetRecyclerViewHolder {
        val binding = PetItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return PetRecyclerViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return pets.size
    }

    override fun onBindViewHolder(holder: PetRecyclerViewHolder, position: Int) {
        val pet = pets[position]
        holder.bind(pet, clickListener)
    }

    fun setData(petsList: List<PetModel>){
        pets.clear()
        pets.addAll(petsList)
    }
}