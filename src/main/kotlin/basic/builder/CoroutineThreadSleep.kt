package basic.builder

import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

fun main() = runBlocking {
    launch {
        println("launch: ${Thread.currentThread().name}")
        println("World!")
    }

    println("runBlocking: ${Thread.currentThread().name}")
    Thread.sleep(1000L)
    println("Hello")
}