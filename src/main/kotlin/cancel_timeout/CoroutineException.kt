package cancel_timeout

import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

suspend fun doOneTwoThree() = coroutineScope {
    val job1 = launch {
        try{
            println("launch1: ${Thread.currentThread().name}")
            delay(1000L)
            println("3!")
        }finally {
            println("job1 is finishing!")
        }
    }

    val job2 = launch {
        try{
            println("launch2: ${Thread.currentThread().name}")
            delay(1000L)
            println("1!")
        }finally {
            println("job2 is finishing!")
        }
    }

    val job3 = launch {
        try{
            println("launch3: ${Thread.currentThread().name}")
            delay(1000L)
            println("2!")
        }finally {
            println("job3 is finishing!")
        }
    }

    delay(800L)
    job1.cancel()   // JobCancellationException 발생
    job2.cancel()
    job3.cancel()
    println("4!")
}

fun main() = runBlocking {
    doOneTwoThree()
    println("runBLocking: ${Thread.currentThread().name}")
    println("5!")
}