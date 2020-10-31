package com.ryunen344.crypto.room

import android.app.Application
import androidx.room.Room
import com.ryunen344.crypto.room.db.DemoDataBase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.asExecutor
import timber.log.Timber

class MainApplication : Application() {

    override fun onCreate() {
        super.onCreate()
        Timber.plant(Timber.DebugTree())
        database = Room.databaseBuilder(applicationContext, DemoDataBase::class.java, "demo.db")
            .setQueryExecutor(Dispatchers.IO.asExecutor())
            .setTransactionExecutor(Dispatchers.IO.asExecutor())
            .fallbackToDestructiveMigration()
            .build()
    }

    companion object {
        lateinit var database: DemoDataBase
    }
}
