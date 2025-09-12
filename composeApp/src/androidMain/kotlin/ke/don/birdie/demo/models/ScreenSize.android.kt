/*
 * Copyright © 2025 Donald O. Isoe (isoedonald@gmail.com)
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *       http://www.apache.org/licenses/LICENSE-2.0
 */
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
