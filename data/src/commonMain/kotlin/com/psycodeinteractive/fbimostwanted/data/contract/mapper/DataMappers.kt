package com.psycodeinteractive.fbimostwanted.data.contract.mapper

import com.psycodeinteractive.fbimostwanted.data.contract.model.ApiMapperException
import com.psycodeinteractive.fbimostwanted.domain.contract.model.DataMapperException

abstract class ApiToDataMapper<Input : Any, Output : Any> {
    fun toData(input: Input): Output = try {
        map(input)
    } catch (throwable: Throwable) {
        throw DataMapperException("Could not map ${input::class.simpleName}", throwable)
    }

    protected abstract fun map(input: Input): Output
}

abstract class DataToApiMapper<Input : Any, Output : Any> {
    fun toApi(input: Input): Output = try {
        map(input)
    } catch (throwable: Throwable) {
        throw ApiMapperException("Could not map ${input::class.simpleName}", throwable)
    }

    protected abstract fun map(input: Input): Output
}
