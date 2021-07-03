package com.ashwin.android.hiltsandbox

import android.app.Application
import dagger.hilt.android.HiltAndroidApp

/**
 * This is necessary for Hilt
 */
@HiltAndroidApp
class MainApplication : Application()
