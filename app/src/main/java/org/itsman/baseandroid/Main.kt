package org.itsman.baseandroid

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.cancelAndJoin
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
    var job =launch {
        app("launch")
        try {

        }finally {
            app("finally")
        }
    }
    job.cancelAndJoin()
}

class AA<out T>(val a: T) {
    fun foo(): T {
        return a
    }
}

fun test(){
    GlobalScope.launch {  }
}
suspend fun app(a:String){
    delay(1000)
    println("suspend fun $a")
}
