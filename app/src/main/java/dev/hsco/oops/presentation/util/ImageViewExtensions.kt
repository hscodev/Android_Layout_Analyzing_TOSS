package dev.hsco.oops.presentation.util

import android.widget.ImageView
import androidx.databinding.BindingAdapter


@BindingAdapter("android:src")
fun ImageView.setImageResource(resource: Int) {
    setImageResource(resource)
}