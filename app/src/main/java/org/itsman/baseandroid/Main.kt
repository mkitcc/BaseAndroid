package org.itsman.baseandroid

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.withContext

fun main(): Unit = runBlocking {
    var a: AA<String> = AA("hello")
    var b: AA<Any> = AA(Pair("asdf", "asdfasd"))

    b = a
    println(b.foo())
    println(b.a)
}

class AA<out T>(val a: T) {
    fun foo(): T {
        return a
    }
}
