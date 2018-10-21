package com.lounah.docsviewer.di.common

import com.lounah.docsviewer.app.DocsViewerApplication

object AppInjector {

    fun init(app: DocsViewerApplication) {
        DaggerAppComponent
                .builder()
                .application(app)
                .appContext(app)
                .build()
                .inject(app)
    }
}