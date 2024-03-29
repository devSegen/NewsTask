package com.app.newstask

import android.app.Application
import android.content.Context
import com.app.data.di.DataModule
import com.app.domain.di.DomainModule
import com.app.newstask.di.AppModule
import org.koin.android.BuildConfig
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin
import org.koin.core.logger.Level
import timber.log.Timber

class App : Application() {

    companion object {
        lateinit var appContext: Context
    }

    override fun onCreate() {
        super.onCreate()
        appContext = applicationContext
        if (BuildConfig.DEBUG) {
            Timber.plant(Timber.DebugTree())
        }
      //1
/*        startKoin {
            androidContext(appContext)
            androidLogger(if (BuildConfig.DEBUG) Level.ERROR else Level.NONE)
            modules(modules)
        }*/
    }
//2
/*    private val modules = listOf(
        DataModule().module,
        DomainModule().module,
        AppModule().module
    )*/
}
