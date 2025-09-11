package ke.don.birdie.demo.models

import android.content.res.Resources

actual fun getScreenWidth(): Float {
    val configuration = Resources.getSystem().configuration
    return configuration.screenWidthDp.toFloat() // Returns screen width in dp
}

actual fun getScreenHeight(): Float {
    val configuration = Resources.getSystem().configuration
    return configuration.screenHeightDp.toFloat()
}