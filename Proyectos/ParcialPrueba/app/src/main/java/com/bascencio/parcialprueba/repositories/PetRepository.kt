package com.bascencio.parcialprueba.repositories

import com.bascencio.parcialprueba.data.model.PetModel
import com.bascencio.parcialprueba.data.pets

class PetRepository(private val repository: MutableList<PetModel>) {
    fun getPets() = pets

    fun addPets(pet: PetModel) = pets.add(pet)
}