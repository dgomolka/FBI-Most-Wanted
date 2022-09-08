package com.psycodeinteractive.fbimostwanted.domain.feature.mostwanted.repository

import com.psycodeinteractive.fbimostwanted.domain.feature.mostwanted.model.MostWantedPersonDomainModel

interface MostWantedRepository {
    suspend fun getMostWantedList(): List<MostWantedPersonDomainModel>
    suspend fun getMostWantedPerson(personId: String): MostWantedPersonDomainModel
}
