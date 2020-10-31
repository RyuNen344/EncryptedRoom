package com.ryunen344.crypto.room.db.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.ryunen344.crypto.room.db.entity.DemoEntity
import kotlinx.coroutines.flow.Flow

@Dao
abstract class DemoDao {

    @Query("SELECT * FROM demo")
    abstract fun select(): Flow<DemoEntity>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    abstract fun insert(demoEntity: DemoEntity)
}
