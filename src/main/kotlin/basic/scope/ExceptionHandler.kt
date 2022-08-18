package basic.scope

import kotlinx.coroutines.*
import kotlin.random.Random

suspend fun printRandom3() {
    delay(1000L)
    println(Random.nextInt(0, 500))
}

suspend fun printRandom4() {
    delay(500L)
    throw ArithmeticException()
}

val ceh = CoroutineExceptionHandler { _, throwable ->
    println("Something happen: ${throwable}")
}

fun main() = runBlocking<Unit> {
    val scope = CoroutineScope(Dispatchers.IO)
    val job = scope.launch(ceh) {
        launch { printRandom3() }
        launch { printRandom4() }
    }
    job.join()
}