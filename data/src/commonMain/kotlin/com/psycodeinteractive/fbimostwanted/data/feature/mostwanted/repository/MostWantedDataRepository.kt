package com.psycodeinteractive.fbimostwanted.data.feature.mostwanted.repository

import com.psycodeinteractive.fbimostwanted.data.feature.mostwanted.source.MostWantedDataSource
import com.psycodeinteractive.fbimostwanted.domain.feature.mostwanted.model.MostWantedPersonDomainModel
import com.psycodeinteractive.fbimostwanted.domain.feature.mostwanted.repository.MostWantedRepository

class MostWantedDataRepository(
    private val mostWantedDataSource: MostWantedDataSource
) : MostWantedRepository {
    override fun getMostWantedList(): List<MostWantedPersonDomainModel> {
        TODO()
    }

    override fun getMostWantedPerson(personId: String): MostWantedPersonDomainModel {
        TODO()
    }
}
