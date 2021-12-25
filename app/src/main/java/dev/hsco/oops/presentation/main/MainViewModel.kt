package dev.hsco.oops.presentation.main

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MainViewModel : ViewModel() {

    private val _bottomNavigationBgTransition = MutableLiveData<Boolean>()
    val bottomNavigationBgTransition: LiveData<Boolean> = _bottomNavigationBgTransition

    fun setBottomNavigationBgTransition(transition: Boolean) {
        _bottomNavigationBgTransition.value = transition
    }
}