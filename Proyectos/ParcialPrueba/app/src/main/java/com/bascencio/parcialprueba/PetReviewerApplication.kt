package com.bascencio.parcialprueba

import android.app.Application
import com.bascencio.parcialprueba.data.pets
import com.bascencio.parcialprueba.repositories.PetRepository

class PetReviewerApplication: Application() {
    val petRepository: PetRepository by lazy {
        PetRepository(pets)
    }
}