package flow.flat

import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.runBlocking

fun requestFlow2(i: Int): Flow<String> = flow{
    emit("$i: First")
    delay(500)
    emit("$i: Second")
}

fun main() = runBlocking {
    val startTime = System.currentTimeMillis()
    (1..3).asFlow().onEach { delay(100) }
        .flatMapMerge {
            requestFlow2(it)
        }
        .collect { value ->
            println("$value at ${System.currentTimeMillis() - startTime} ms from start")
        }
}