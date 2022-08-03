package dispatcher

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.async
import kotlinx.coroutines.delay
import kotlinx.coroutines.runBlocking

fun main() = runBlocking<Unit> {
    async(Dispatchers.Unconfined) {
        println("Unconfined / ${Thread.currentThread().name}")
        delay(1000L)
        println("Unconfined / ${Thread.currentThread().name}")
        delay(1000L)
        println("Unconfined / ${Thread.currentThread().name}")
    }
}