package android.vafeen.synchronousflow.di.base

import android.vafeen.synchronousflow.di.someModule
import org.koin.dsl.module

internal val baseModule  = module {
  includes(someModule)
}
