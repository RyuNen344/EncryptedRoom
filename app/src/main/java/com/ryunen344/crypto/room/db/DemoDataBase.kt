package com.ryunen344.crypto.room.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.ryunen344.crypto.room.db.dao.DemoDao
import com.ryunen344.crypto.room.db.entity.DemoEntity

@Database(
    entities = [
        DemoEntity::class
    ],
    version = 1,
    exportSchema = false
)
abstract class DemoDataBase : RoomDatabase() {
    abstract fun demoDao(): DemoDao
}
