package android.vafeen.synchronousflow.di

import android.vafeen.synchronousflow.MainActivityViewModel
import org.koin.core.module.dsl.viewModelOf
import org.koin.dsl.module

internal val someModule = module {
    viewModelOf(::MainActivityViewModel)
}