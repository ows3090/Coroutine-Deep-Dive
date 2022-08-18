package basic.cancel_timeout

import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

suspend fun doOneTwoThree2() = coroutineScope {
    val job1 = launch {
        println("launch1 : ${Thread.currentThread().name}")
        delay(1000L)
        println("3!")
    }
    //job.join()

    val job2 = launch {
        println("launch2 : ${Thread.currentThread().name}")
        println("1!")
    }

    val job3 = launch {
        println("launch3: ${Thread.currentThread().name}")
        delay(500L)
        println("2!")
    }

    delay(800L)
    job1.cancel()
    job2.cancel()
    job3.cancel()
    println("4!")
}

fun main() = runBlocking {
    doOneTwoThree2() // runBlocking의 coroutineScope를 사용
    println("runBlocking after ${Thread.currentThread().name}")
    println("5!")
}