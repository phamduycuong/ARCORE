package com.gj.arcoredraw

import com.blankj.utilcode.util.ToastUtils
import com.google.ar.core.exceptions.UnavailableApkTooOldException
import com.google.ar.core.exceptions.UnavailableArcoreNotInstalledException
import com.google.ar.core.exceptions.UnavailableDeviceNotCompatibleException
import com.google.ar.core.exceptions.UnavailableException
import com.google.ar.core.exceptions.UnavailableSdkTooOldException
import com.google.ar.sceneform.ux.ArFragment

class MyArFragment : ArFragment() {
    override fun handleSessionException(sessionException: UnavailableException) {
        val message: String
        when (sessionException) {
            is UnavailableArcoreNotInstalledException -> message = "Please install ARCore"
            is UnavailableApkTooOldException -> message = "Please upgrade ARCore"
            is UnavailableSdkTooOldException -> message = "Please upgrade the app"
            is UnavailableDeviceNotCompatibleException -> message = "The current equipment department does not support AR"
            else -> {
                message = "Failed to create AR session, please check model adaptation, arcore version and system version"
                val var3 = sessionException.toString()
            }
        }
        ToastUtils.showLong(message)
    }
}
