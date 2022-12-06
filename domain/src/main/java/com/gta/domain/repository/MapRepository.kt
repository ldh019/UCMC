package com.gta.domain.repository

import com.gta.domain.model.LocationInfo
import com.gta.domain.model.UCMCResult
import kotlinx.coroutines.flow.Flow

interface MapRepository {
    fun getSearchAddressList(query: String): Flow<List<LocationInfo>>
    fun getSearchCoordinate(longitude: String, latitude: String): Flow<String?>
    fun getSearchAddressList(query: String): Flow<UCMCResult<List<LocationInfo>>>
}
