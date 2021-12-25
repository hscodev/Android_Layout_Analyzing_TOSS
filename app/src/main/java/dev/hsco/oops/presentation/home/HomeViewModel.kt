package dev.hsco.oops.presentation.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class HomeViewModel : ViewModel() {

    private val _content = MutableLiveData<List<HomeDataItem>>()
    val content: LiveData<List<HomeDataItem>> = _content

    fun load() {
        _content.value = listOf(
            HomeDataItem.CompetitionDataItem(),
            HomeDataItem.AccountDataItem(),
            HomeDataItem.AccountBookDataItem(),
            HomeDataItem.AddAccountDataItem()
        )
    }
}