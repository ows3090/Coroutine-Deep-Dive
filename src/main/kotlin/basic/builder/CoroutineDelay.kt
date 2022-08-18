package basic.builder

import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

fun main() = runBlocking {
    launch {
        println("launch: ${Thread.currentThread().name}")
        delay(100L) // suspension point(중단점)
        println("World!")
    }

    println("runBlocking: ${Thread.currentThread().name}")
    delay(500L)
    println("Hello")
}