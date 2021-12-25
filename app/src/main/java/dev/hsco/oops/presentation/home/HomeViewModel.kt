package dev.hsco.oops.presentation.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import dev.hsco.oops.presentation.home.view_holder.AccountBookViewData
import dev.hsco.oops.presentation.util.setValueIfNew

class HomeViewModel : ViewModel() {

    private val _content = MutableLiveData<List<HomeDataItem>>()
    val content: LiveData<List<HomeDataItem>> = _content

    private val _stickyVisible = MutableLiveData<Boolean>()
    val stickyVisible: LiveData<Boolean> = _stickyVisible

    fun load() {
        _content.value = listOf(
            HomeDataItem.CompetitionDataItem(),
            HomeDataItem.AccountDataItem(),
            HomeDataItem.AccountBookDataItem(AccountBookViewData()),
            HomeDataItem.AddAccountDataItem()
        )
    }

    fun onStickyVisible(visible: Boolean) {
        _stickyVisible.setValueIfNew(visible)
        setAccountBookDataItemBgExpand(visible)
    }

    private fun setAccountBookDataItemBgExpand(expand: Boolean){
        content.value
            ?.find { it is HomeDataItem.AccountBookDataItem }
            ?.let { it as HomeDataItem.AccountBookDataItem }
            ?.apply { viewData.setBgExpand(expand) }
    }
}