package com.loyo.myapplication.Util;

import kotlinx.coroutines.*

data class CoroutineCallback(
    var block: suspend () -> Unit = {},
    var error: (Throwable) -> Unit = {}

)

fun CoroutineScope.safeLaunch(init: CoroutineCallback.() -> Unit): Job {
    val callback=CoroutineCallback().apply(init)
    return launch (CoroutineExceptionHandler{_,throwable->callback.error(throwable)}+GlobalScope.coroutineContext){
        callback.block()
    }
}
