package com.bascencio.parcialprueba.ui.pet

import android.text.Spannable.Factory
import android.widget.Toast
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider.AndroidViewModelFactory.Companion.APPLICATION_KEY
import androidx.lifecycle.viewmodel.initializer
import androidx.lifecycle.viewmodel.viewModelFactory
import com.bascencio.parcialprueba.PetReviewerApplication
import com.bascencio.parcialprueba.data.model.PetModel
import com.bascencio.parcialprueba.repositories.PetRepository

class PetViewModel(private val repository: PetRepository) : ViewModel() {
    var type = MutableLiveData("")
    var name = MutableLiveData("")
    var race = MutableLiveData("")
    var age = MutableLiveData("")
    var gener = MutableLiveData("")

    fun getPets() = repository.getPets()

    private fun addPets(pet: PetModel) = repository.addPets(pet)

    fun createPet(){
        if(!validateData()){
            return
        }
        val pet = PetModel(
            type.value!!,
            name.value!!,
            race.value!!,
            age.value!!,
            gener.value!!
            )
        addPets(pet)
        clearData()
    }

    private fun validateData() : Boolean{
        when{
            type.value.isNullOrEmpty() -> return false
            name.value.isNullOrEmpty() -> return false
            race.value.isNullOrEmpty() -> return false
            age.value.isNullOrEmpty() -> return false
            gener.value.isNullOrEmpty() -> return false
        }
        return true
    }
    fun clearData(){
        type.value = ""
        name.value = ""
        race.value = ""
        age.value = ""
        gener.value = ""
    }

    fun setSelectedPet(pet: PetModel){
        type.value = pet.race
        name.value = pet.name
        race.value = pet.race
        age.value = pet.age
        gener.value = pet.gener
    }

    companion object{
        val Factory = viewModelFactory {
            initializer {
                val app = this[APPLICATION_KEY] as PetReviewerApplication
                PetViewModel(app.petRepository)
            }
        }
    }
}