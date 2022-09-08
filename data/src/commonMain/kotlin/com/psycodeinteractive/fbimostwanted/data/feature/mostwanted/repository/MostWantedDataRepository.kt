package com.psycodeinteractive.fbimostwanted.data.feature.mostwanted.repository

import com.psycodeinteractive.fbimostwanted.data.feature.mostwanted.mapper.MostWantedPersonDataToDomainMapper
import com.psycodeinteractive.fbimostwanted.data.feature.mostwanted.source.MostWantedDataSource
import com.psycodeinteractive.fbimostwanted.domain.feature.mostwanted.repository.MostWantedRepository
import kotlinx.coroutines.flow.first

class MostWantedDataRepository(
    private val mostWantedDataSource: MostWantedDataSource,
    private val mostWantedPersonDataToDomainMapper: MostWantedPersonDataToDomainMapper
) : MostWantedRepository {
    override suspend fun getMostWantedList() =
        mostWantedDataSource.get().first().map(mostWantedPersonDataToDomainMapper::toDomain)

    override suspend fun getMostWantedPerson(personId: String) = mostWantedPersonDataToDomainMapper.toDomain(
        mostWantedDataSource.get().first().first { mostWantedList -> mostWantedList.id == personId }
    )
}
