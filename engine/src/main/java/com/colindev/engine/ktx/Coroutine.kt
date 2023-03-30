package com.colindev.engine.ktx

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch

fun CoroutineScope.launchUI(block: suspend CoroutineScope.() -> Unit): Job {
    return this.launch(Dispatchers.Main, block = block)
}

fun CoroutineScope.launchIO(block: suspend CoroutineScope.() -> Unit): Job {
    return this.launch(Dispatchers.IO, block = block)
}
