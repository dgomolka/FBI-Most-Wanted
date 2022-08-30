package com.psycodeinteractive.fbimostwanted.domain.feature.mostwanted.repository

import com.psycodeinteractive.fbimostwanted.domain.feature.mostwanted.model.MostWantedPersonDomainModel

interface MostWantedRepository {
    fun getMostWantedList(): List<MostWantedPersonDomainModel>
    fun getMostWantedPerson(personId: String): MostWantedPersonDomainModel
}
