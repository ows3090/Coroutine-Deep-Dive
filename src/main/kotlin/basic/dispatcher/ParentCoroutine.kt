package basic.dispatcher

import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import kotlin.system.measureTimeMillis

fun main() = runBlocking {
    val elapsed = measureTimeMillis {
        val job = launch {
            launch {
                println("launch1: ${Thread.currentThread().name}")
                delay(5000L)
            }

            launch {
                println("launch2: ${Thread.currentThread().name}")
                delay(10L)
            }
        }
        job.join()
    }
    println(elapsed)
}