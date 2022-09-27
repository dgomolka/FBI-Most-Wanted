package com.psycodeinteractive.fbimostwanted.domain.feature.session.repository

interface AppSessionRepository {
    suspend fun startSession()
    suspend fun stopSession()
    suspend fun clearSession()
}
