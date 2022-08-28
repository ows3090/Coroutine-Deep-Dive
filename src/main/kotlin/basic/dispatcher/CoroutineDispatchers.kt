package basic.dispatcher

import kotlinx.coroutines.*

fun main() = runBlocking<Unit> {
    launch {
        println("부모의 컨텍스트 / ${Thread.currentThread().name}")
    }

    launch(Dispatchers.Default) {
        println("Default / ${Thread.currentThread().name}")
        withContext(Dispatchers.IO){
            println("Default IO / ${Thread.currentThread().name}")
        }
    }

    launch(Dispatchers.IO) {
        println("IO / ${Thread.currentThread().name}")
    }

    launch(Dispatchers.Unconfined) {
        println("Unconfined / ${Thread.currentThread().name}")
    }

    launch(newSingleThreadContext("wonseok")) {
        println("newSingleThreadContext / ${Thread.currentThread().name}")
    }

    GlobalScope.launch {
        println("GlobalScope / ${Thread.currentThread().name}")
    }
}