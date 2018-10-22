package com.lounah.docsviewer.data.datasource.local.dao

import android.arch.persistence.room.Delete
import android.arch.persistence.room.Insert
import android.arch.persistence.room.OnConflictStrategy

interface BaseDao<T> {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(value: T)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertAll(vararg values: T)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertAll(values: List<T>)

    @Delete
    fun delete(value: T)
}