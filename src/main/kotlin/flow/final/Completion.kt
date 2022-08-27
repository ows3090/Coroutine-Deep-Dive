package flow.final

import kotlinx.coroutines.flow.*
import kotlinx.coroutines.runBlocking
import kotlin.IllegalStateException

fun simple2(): Flow<Int> = (1..3).asFlow()

fun main() = runBlocking {
    simple2()
        .map {
            if(it > 2){
                throw IllegalStateException()
            }
            it+1
        }
        .catch { cause -> println("Caught exception") }
        .onCompletion { cause -> println("Done $cause") }
        .collect { value -> println(value) }
}