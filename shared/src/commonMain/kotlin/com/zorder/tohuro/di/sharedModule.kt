package com.zorder.tohuro.di

import com.zorder.tohuro.data.PersonRepository
import com.zorder.tohuro.detail.PersonDetailScreenModel
import com.zorder.tohuro.list.PersonListScreenModel
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

// for ios
fun initKoin() {
    initKoin {  }
}

val commonModule = module {
    singleOf(::PersonRepository)
    factory { (id: String) -> PersonDetailScreenModel(id, repository = get()) }
    factoryOf(::PersonListScreenModel)
}
