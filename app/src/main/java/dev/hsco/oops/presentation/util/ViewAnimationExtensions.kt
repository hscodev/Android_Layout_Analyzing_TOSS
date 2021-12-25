package dev.hsco.oops.presentation.util

import android.view.View
import android.view.ViewGroup
import android.view.animation.AccelerateDecelerateInterpolator
import android.view.animation.Animation
import android.view.animation.Transformation

fun View.collapseAnimation(horizontalMarginDp: Int) {
    val currentMargin = (layoutParams as? ViewGroup.MarginLayoutParams)?.marginStart ?: 0
    val horizontalMargin = horizontalMarginDp / 2
    val targetMargin = horizontalMargin - currentMargin
    val animation = object : Animation() {
        override fun applyTransformation(interpolatedTime: Float, t: Transformation?) {
            val animateMargin = currentMargin + (targetMargin * interpolatedTime)
            layoutParams = (layoutParams as? ViewGroup.MarginLayoutParams)?.apply {
                marginStart = animateMargin.toInt()
                marginEnd = animateMargin.toInt()
            }
        }
    }.apply {
        duration = 200
        interpolator = AccelerateDecelerateInterpolator()
    }

    startAnimation(animation)
}

fun View.expandAnimation(horizontalMarginDp: Int) {
    val horizontalMargin = horizontalMarginDp / 2
    val animation = object : Animation() {
        override fun applyTransformation(interpolatedTime: Float, t: Transformation?) {
            val animateMargin = horizontalMargin - (horizontalMargin * interpolatedTime)
            layoutParams = (layoutParams as? ViewGroup.MarginLayoutParams)?.apply {
                marginStart = animateMargin.toInt()
                marginEnd = animateMargin.toInt()
            }
        }
    }.apply {
        duration = 200
        interpolator = AccelerateDecelerateInterpolator()
    }

    startAnimation(animation)
}