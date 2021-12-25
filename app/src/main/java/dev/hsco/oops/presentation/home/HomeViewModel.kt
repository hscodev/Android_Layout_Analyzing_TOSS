package dev.hsco.oops.presentation.home

import android.util.Log
import androidx.lifecycle.*
import dev.hsco.oops.presentation.util.setValueIfNew
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach

class HomeViewModel : ViewModel() {

    private val _content = MutableLiveData<List<HomeDataItem>>()
    val content: LiveData<List<HomeDataItem>> = _content

    private val _stickyVisible = MutableLiveData<Boolean>()
    val stickyVisible: LiveData<Boolean> = _stickyVisible

    init {
        stickyVisible.asFlow().onEach {
            Log.e("CCOOVV", "stickyVisible : $it")
        }.launchIn(viewModelScope)
    }

    fun load() {
        _content.value = listOf(
            HomeDataItem.CompetitionDataItem(),
            HomeDataItem.AccountDataItem(),
            HomeDataItem.AccountBookDataItem(),
            HomeDataItem.AddAccountDataItem()
        )
    }

    fun onStickyVisible(visible: Boolean) {
        _stickyVisible.setValueIfNew(visible)
    }
}