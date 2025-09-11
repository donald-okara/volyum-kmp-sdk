package ke.don.birdie.demo.models

import java.awt.Toolkit

actual fun getScreenWidth(): Float {
    val screenSize = Toolkit.getDefaultToolkit().screenSize
    return screenSize.width.toFloat()
}

actual fun getScreenHeight(): Float {
    val screenSize = Toolkit.getDefaultToolkit().screenSize
    return screenSize.height.toFloat()
}
