package com.lounah.docsviewer.di.common

import javax.inject.Qualifier

@Target(AnnotationTarget.VALUE_PARAMETER)
@Qualifier
@Retention(AnnotationRetention.RUNTIME)
annotation class ApplicationContext