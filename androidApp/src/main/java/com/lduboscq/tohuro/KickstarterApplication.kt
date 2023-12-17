package com.lduboscq.tohuro

import android.app.Application
import com.lduboscq.tohuro.di.androidAppModule
import com.zorder.tohuro.di.initKoin
import com.zorder.tohuro.ui.appContextForImagesMP
import io.github.aakira.napier.DebugAntilog
import io.github.aakira.napier.Napier
import org.koin.android.ext.koin.androidContext
import org.koin.dsl.module

class KickstarterApplication : Application() {
    override fun onCreate() {
        super.onCreate()

        Napier.base(DebugAntilog())

        appContextForImagesMP = this

        initKoin {
            modules(
                listOf(
                    module { androidContext(this@KickstarterApplication) },
                    androidAppModule
                )
            )
        }
    }
}
