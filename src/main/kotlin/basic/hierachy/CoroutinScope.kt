package basic.hierachy

import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

suspend fun doOneTwoThree1() = coroutineScope {
    println("doOneTwoThree: ${Thread.currentThread().name}")
    launch {
        println("launch1 : ${Thread.currentThread().name}")
        delay(1000L)
        println("3!")
    }

    launch {
        println("launch2 : ${Thread.currentThread().name}")
        println("1!")
    }

    launch {
        println("launch3: ${Thread.currentThread().name}")
        delay(500L)
        println("2!")
    }

    delay(5000L)
    println("4!")
}

fun main() = runBlocking {
    println("runBlocking ${Thread.currentThread().name}")

    launch {
        println("launch4: ${Thread.currentThread().name}")
        delay(500L)
        println("6!")
    }
    doOneTwoThree1() // runBlocking의 coroutineScope를 사용

    launch {
        println("launch5: ${Thread.currentThread().name}")
        delay(500L)
        println("7!")
    }
    println("runBlocking after ${Thread.currentThread().name}")
    println("5!")
}