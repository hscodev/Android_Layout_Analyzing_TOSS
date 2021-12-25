package dev.hsco.oops.presentation.util

import android.graphics.Outline
import android.graphics.drawable.TransitionDrawable
import android.view.View
import android.view.ViewOutlineProvider
import androidx.databinding.BindingAdapter

@BindingAdapter("visibilityIf")
fun View.setVisibilityIf(visible: Boolean?) {
    visibility = if (visible == true) View.VISIBLE else View.GONE
}

@BindingAdapter(value = ["toggleExpandAnimation", "toggleExpandAnimationMargin"], requireAll = true)
fun View.toggleExpandAnimation(toggleExpandAnimation: Boolean, toggleExpandAnimationMargin: Int) {
    if (toggleExpandAnimation) {
        expandAnimation(toggleExpandAnimationMargin.dp)
    } else {
        collapseAnimation(toggleExpandAnimationMargin.dp)
    }
}

@BindingAdapter("slideUpAnimation")
fun View.slideUpAnimation(animate: Boolean) {
    if (animate) {
        slideUpAnimation()
    }
}

@BindingAdapter("runTransitionDrawable")
fun View.runTransitionDrawable(transition: Boolean) {
    (background as? TransitionDrawable)?.run {
        if(transition){
            startTransition(200)
        }else{
            reverseTransition(200)
        }
    }
}

@BindingAdapter("topCornerRadiusDp")
fun View.setTopCornerRound(radiusDp: Int) {
    outlineProvider = object : ViewOutlineProvider() {
        override fun getOutline(view: View, outline: Outline) {
            outline.setRoundRect(0, 0, view.width, view.height + radiusDp, radiusDp.toFloat())
        }
    }
    clipToOutline = true
}

@BindingAdapter(value = ["toggleRadiusAnimation", "toggleRadiusAnimationValue"], requireAll = true)
fun View.toggleRadiusAnimation(toggleRadiusAnimation: Boolean, toggleRadiusAnimationValue: Int) {
    if (toggleRadiusAnimation) {
        expandRadiusAnimation(toggleRadiusAnimationValue)
    } else {
        radiusAnimation(toggleRadiusAnimationValue)
    }
}