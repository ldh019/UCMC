package com.gta.presentation.ui.map

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.gta.domain.model.Coordinate
import com.gta.domain.model.LocationInfo
import com.gta.domain.model.SimpleCar
import com.gta.domain.usecase.map.GetNearCarsUseCase
import com.gta.domain.usecase.map.GetSearchAddressUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CompletableJob
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.FlowPreview
import kotlinx.coroutines.SupervisorJob
import kotlinx.coroutines.channels.BufferOverflow
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharedFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.debounce
import kotlinx.coroutines.flow.flatMapLatest
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.launch
import kotlinx.coroutines.plus
import timber.log.Timber
import javax.inject.Inject

@OptIn(FlowPreview::class, ExperimentalCoroutinesApi::class)
@HiltViewModel
class MapViewModel @Inject constructor(
    private val getNearCarsUseCase: GetNearCarsUseCase,
    private val searchAddressUseCase: GetSearchAddressUseCase
) :
    ViewModel() {
    private val SEARCH_TIMEOUT = 5000L

    private var _carsRequest = MutableSharedFlow<Pair<Coordinate, Coordinate>>(
        extraBufferCapacity = 1,
        onBufferOverflow = BufferOverflow.DROP_OLDEST
    )
    val carsRequest: SharedFlow<Pair<Coordinate, Coordinate>> get() = _carsRequest

    private var _carsResponse = MutableSharedFlow<List<SimpleCar>>()
    val carsResponse: SharedFlow<List<SimpleCar>> get() = _carsResponse

    private var _selectCar = MutableStateFlow(SimpleCar())
    val selectCar: StateFlow<SimpleCar> get() = _selectCar

    private var _searchRequest = MutableSharedFlow<String>(
        extraBufferCapacity = 1,
        onBufferOverflow = BufferOverflow.DROP_OLDEST
    )
    private val searchRequest: SharedFlow<String> get() = _searchRequest

    private var _searchResponse = MutableSharedFlow<List<LocationInfo>>()
    val searchResponse: SharedFlow<List<LocationInfo>> get() = _searchResponse

    private lateinit var collectJob: CompletableJob

    fun startCollect() {
        collectJob = SupervisorJob()

        searchRequest
            .debounce(SEARCH_TIMEOUT)
            .flatMapLatest { query ->
                Timber.d("collect? 1")
                searchAddressUseCase(query)
            }.flowOn(Dispatchers.IO)
            .onEach { rawList ->
                Timber.d("collect? 2")
                _searchResponse.emit(rawList)
            }.launchIn(viewModelScope + collectJob)

        carsRequest
            .debounce(SEARCH_TIMEOUT)
            .flatMapLatest { (min, max) ->
                getNearCarsUseCase(min, max)
            }.flowOn(Dispatchers.IO)
            .onEach { list ->
                _carsResponse.emit(list)
            }.launchIn(viewModelScope + collectJob)
    }

    fun stopCollect() {
        collectJob.cancel()
    }

    fun setPosition(min: Coordinate, max: Coordinate) {
        viewModelScope.launch {
            _carsRequest.emit(Pair(min, max))
        }
    }

    fun setSelected(car: SimpleCar) {
        viewModelScope.launch {
            _selectCar.emit(car)
        }
    }

    fun setQuery(query: String) {
        viewModelScope.launch {
            _searchRequest.emit(query)
        }
    }
}
