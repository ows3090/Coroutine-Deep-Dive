package flow.operator

import kotlinx.coroutines.flow.*
import kotlinx.coroutines.delay
import kotlinx.coroutines.runBlocking

suspend fun someCalc5(i: Int): Int{
    delay(100L)
    return i*2
}

fun main() = runBlocking {
    (1..20).asFlow().transform {
        emit(it)
        emit(someCalc5(it))
    }.dropWhile {
        it < 5
    }.collect {
        println(it)
    }
}