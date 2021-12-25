package dev.hsco.oops.presentation.util

import androidx.lifecycle.MutableLiveData


fun <T> MutableLiveData<T>.setValueIfNew(newValue: T) {
    if (this.value != newValue) value = newValue
}
