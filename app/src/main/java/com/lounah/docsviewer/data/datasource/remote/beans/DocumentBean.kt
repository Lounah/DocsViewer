package com.lounah.docsviewer.data.datasource.remote.beans

import com.google.gson.annotations.SerializedName

data class DocumentBean(
        @SerializedName("name") val name: String? = "",
        @SerializedName("id") val id: String? = "",
        @SerializedName("type") val type: String? = "",
        @SerializedName("link") val link: String? = ""
)