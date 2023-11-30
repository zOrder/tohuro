package com.zorder.tohuro.di

import com.zorder.tohuro.list.MoodListScreenModel
import com.zorder.tohuro.data.MoodRepository
import org.koin.core.context.startKoin
import org.koin.core.module.Module
import org.koin.core.module.dsl.factoryOf
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.KoinAppDeclaration
import org.koin.dsl.module

expect fun sharedPlatformModule(): Module

fun initKoin(appDeclaration: KoinAppDeclaration = {}) = startKoin {
    appDeclaration()
    modules(commonModule, sharedPlatformModule())
}

val commonModule = module {
    singleOf(::MoodRepository)
    factory { (id: String) -> MoodListScreenModel(id, moodsRepository = get()) }
    factoryOf(::MoodListScreenModel)
}