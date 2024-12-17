package android.vafeen.synchronousflow.app

import android.app.Application
import android.vafeen.synchronousflow.di.base.baseModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

internal class App : Application() {
    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidContext(this@App)
            modules(baseModule)
        }
    }
}