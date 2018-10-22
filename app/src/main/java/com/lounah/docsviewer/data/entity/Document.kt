package com.lounah.docsviewer.data.entity

import android.arch.persistence.room.Entity
import android.arch.persistence.room.PrimaryKey

@Entity(tableName = "documents")
data class Document(
        var name: String = "",
        @PrimaryKey var id: String = "",
        var type: String = "",
        var link: String = ""
)