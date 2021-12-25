package dev.hsco.oops.presentation.util

import android.view.View
import android.view.ViewGroup
import android.view.animation.AccelerateDecelerateInterpolator
import android.view.animation.Animation
import android.view.animation.Transformation
import androidx.core.view.marginTop

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
        duration = 150
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
        duration = 150
        interpolator = AccelerateDecelerateInterpolator()
    }

    startAnimation(animation)
}

fun View.slideUpAnimation(marginDp: Int) {
    val animation = object : Animation() {
        override fun applyTransformation(interpolatedTime: Float, t: Transformation?) {
            val animateMargin = marginDp.dp * interpolatedTime
            layoutParams = (layoutParams as? ViewGroup.MarginLayoutParams)?.apply {
                setMargins(marginStart, marginTop, marginEnd, animateMargin.toInt())
            }
        }
    }.apply {
        duration = 150
        interpolator = AccelerateDecelerateInterpolator()
    }

    startAnimation(animation)
}

fun View.radiusAnimation(radiusDp: Int) {
    val animation = object : Animation() {
        override fun applyTransformation(interpolatedTime: Float, t: Transformation?) {
            val radius = radiusDp.dp - (radiusDp.dp * interpolatedTime)
            setTopCornerRound(radius.toInt())
        }
    }.apply {
        duration = 200
        interpolator = AccelerateDecelerateInterpolator()
    }

    startAnimation(animation)
}

fun View.expandRadiusAnimation(radiusDp: Int) {
    val animation = object : Animation() {
        override fun applyTransformation(interpolatedTime: Float, t: Transformation?) {
            val radius = (radiusDp.dp * interpolatedTime)
            setTopCornerRound(radius.toInt())
        }
    }.apply {
        duration = 200
        interpolator = AccelerateDecelerateInterpolator()
    }

    startAnimation(animation)
}