package com.zorder.tohuro.di

import com.zorder.tohuro.data.SettingsFactory
import org.koin.core.module.Module
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.module

actual fun sharedPlatformModule(): Module = module {
    singleOf(::SettingsFactory)
}

