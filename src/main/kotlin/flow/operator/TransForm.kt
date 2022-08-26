package flow.operator

import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.asFlow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.transform
import kotlinx.coroutines.runBlocking

suspend fun someCalc(i: Int): Int{
    delay(100L)
    return i*2
}

fun main() = runBlocking {
    (1..20).asFlow().transform {
        emit(it)
        emit(someCalc(it))
    }.collect {
        println(it)
    }
}