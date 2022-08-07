package scope

import kotlinx.coroutines.*
import kotlin.random.Random

suspend fun printRandom5() {
    delay(1000L)
    println(Random.nextInt(0, 500))
}

suspend fun printRandom6() {
    delay(500L)
    throw ArithmeticException()
}

val ceh2 = CoroutineExceptionHandler { _, throwable ->
    println("Something happend: ${throwable}")
}

fun main() = runBlocking<Unit> {
    // CorotineContext에서 parent job도 설정 가능
    val scope = CoroutineScope(Dispatchers.IO + SupervisorJob() + ceh2)
    val job1 = scope.launch { printRandom5() }
    val job2 = scope.launch { printRandom6() }
    joinAll(job1, job2)
}