package basic.dispatcher

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.async
import kotlinx.coroutines.newSingleThreadContext
import kotlinx.coroutines.runBlocking

fun main() = runBlocking<Unit> {
    async {
        println("부모의 컨텍스트 / ${Thread.currentThread().name}")
    }

    async(Dispatchers.Default) {
        println("Default / ${Thread.currentThread().name}")
    }

    async(Dispatchers.IO) {
        println("IO / ${Thread.currentThread().name}")
    }

    async(Dispatchers.Unconfined) {
        println("Unconfined / ${Thread.currentThread().name}")
    }

    async(newSingleThreadContext("wonseok")) {
        println("newSingleThreadContext / ${Thread.currentThread().name}")
    }
}