package flow.operator

import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.runBlocking

suspend fun someCalc3(i: Int): Int{
    delay(100L)
    return i*2
}

fun main() = runBlocking {
    (1..20).asFlow().transform {
        emit(it)
        emit(someCalc3(it))
    }.takeWhile {
        it < 15
    }.collect {
        println(it)
    }
}