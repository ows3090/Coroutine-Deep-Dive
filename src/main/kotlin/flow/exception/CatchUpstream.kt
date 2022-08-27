package flow.exception

import kotlinx.coroutines.flow.*
import kotlinx.coroutines.runBlocking

fun simple4(): Flow<Int> =
    flow {
        for (i in 1..3) {
            println("Emitting $i")
            emit(i)
        }
    }

fun main() = runBlocking {
    try {
        simple4()
            .catch { e -> println("Caught $e") }    // upstream에만 영향
            .collect { value ->
                check(value <= 1) { "Collected $value" }
                println(value)
            }
    } catch (e: Throwable) {
        println("Caught $e")
    }
}