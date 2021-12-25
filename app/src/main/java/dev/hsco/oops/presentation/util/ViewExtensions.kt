package dev.hsco.oops.presentation.util

import android.graphics.drawable.TransitionDrawable
import android.view.View
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