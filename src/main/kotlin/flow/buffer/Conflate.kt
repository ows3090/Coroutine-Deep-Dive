package flow.buffer

import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.conflate
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.runBlocking
import kotlin.system.measureTimeMillis

fun simple3(): Flow<Int> = flow {
    for(i in 1..5){    //  1    2    3    4    5
                       //      100  200  300  400
        delay(100)
        emit(i)
        println("emit ${System.currentTimeMillis()}")
    }
}

fun main() = runBlocking<Unit> {
    val time = measureTimeMillis {
        simple3().conflate().collect { value ->
            println("collect ${System.currentTimeMillis()}")
            delay(300)
            println(value)
        }
    }
    println("Collected in $time ms")
}