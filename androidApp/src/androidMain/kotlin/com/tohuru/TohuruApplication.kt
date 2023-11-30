package com.tohuru

import android.app.Application
import com.tohuru.di.androidAppModule
import com.zorder.tohuro.di.initKoin
import org.koin.android.ext.koin.androidContext
import org.koin.dsl.module

class TohuruApplication : Application() {
    override fun onCreate(){
        super.onCreate()
        initKoin{
            modules(
                    listOf(module{ androidContext(this@TohuruApplication) },
                    androidAppModule
                )
            )
        }
    }
}