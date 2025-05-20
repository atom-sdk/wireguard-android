package com.wireguard.util

import android.app.UiModeManager
import android.content.Context
import android.content.res.Configuration
import android.os.Build

object Util {

    /**
     * Checks if the running device is Amazon TV
     *
     * @return true If running on Amazon TV else false
     */
    fun isAmazonTV(context: Context): Boolean {
        return isRunningOnTV(context) && Build.MANUFACTURER.equals("amazon", ignoreCase = true)
    }

    /**
     * Checks if the running device is Television
     *
     * @return true If running on TV else false
     */
    private fun isRunningOnTV(context: Context): Boolean {
        return (context.getSystemService(Context.UI_MODE_SERVICE) as UiModeManager?)
            ?.currentModeType == Configuration.UI_MODE_TYPE_TELEVISION
    }
}