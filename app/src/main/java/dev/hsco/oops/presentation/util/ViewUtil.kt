package dev.hsco.oops.presentation.util

import android.util.TypedValue
import androidx.annotation.Px
import dev.hsco.oops.App
import kotlin.math.roundToInt


val Int.dp: Int
    @Px
    get() = this.toFloat().dp

val Double.dp: Int
    @Px
    get() = this.toFloat().dp

val Float.dp: Int
    @Px
    get() {
        val metrics = App.instance().resources.displayMetrics
        return TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, this, metrics).roundToInt()
    }