package com.bccxraion.consure

import android.app.Application
import com.bccxraion.consure.di.dataStoreModule
import com.bccxraion.consure.di.networkModule
import com.bccxraion.consure.di.viewModelModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin
import org.koin.core.logger.Level

class Consure: Application() {
    
    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidLogger(Level.NONE)
            androidContext(this@Consure)
            modules(
                listOf(
                    dataStoreModule,
                    networkModule,
                    viewModelModule
                )
            )
        }
    }
    
}