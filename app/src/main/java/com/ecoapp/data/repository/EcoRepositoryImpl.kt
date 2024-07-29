package com.ecoapp.data.repository

import com.ecoapp.data.EcoDataProvider
import com.ecoapp.data.model.EcoItem
import com.ecoapp.domain.repository.EcoRepository
import javax.inject.Inject

class EcoRepositoryImpl @Inject constructor() : EcoRepository {
    override fun getEcoData(): List<EcoItem> {
        return EcoDataProvider.getEcoData()
    }
}