package basic.scope

import kotlinx.coroutines.*
import kotlin.random.Random

suspend fun printRandom7() {
    delay(1000L)
    println(Random.nextInt(0, 500))
}

suspend fun printRandom8() {
    delay(500L)
    throw ArithmeticException()
}

suspend fun supervisoredFunc() = supervisorScope {
    launch { printRandom7() }
    launch(ceh3) { printRandom8() }
}

val ceh3 = CoroutineExceptionHandler { _, throwable ->
    println("Something happend: ${throwable}")
}

fun main() = runBlocking<Unit> {
    val scope = CoroutineScope(Dispatchers.IO)
    val job = scope.launch {
        supervisoredFunc()
    }
    job.join()
}