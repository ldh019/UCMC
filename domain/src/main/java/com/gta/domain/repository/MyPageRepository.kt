package com.gta.domain.repository

import kotlinx.coroutines.flow.Flow

interface MyPageRepository {
    fun setThumbnail(uid: String, uri: String): Flow<String>

    fun deleteThumbnail(uid: String, path: String): Flow<Boolean>
}
