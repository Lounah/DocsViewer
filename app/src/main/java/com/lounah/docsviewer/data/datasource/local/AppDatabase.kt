package com.lounah.docsviewer.data.datasource.local

import android.arch.persistence.room.Database
import android.arch.persistence.room.RoomDatabase
import com.lounah.docsviewer.data.datasource.local.dao.DocsDao
import com.lounah.docsviewer.data.entity.Document

@Database(
        entities = [Document::class],
        version = 2,
        exportSchema = false)
abstract class AppDatabase : RoomDatabase() {
    abstract fun docsDao(): DocsDao
}