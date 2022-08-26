package flow.operator

import kotlinx.coroutines.flow.*
import kotlinx.coroutines.runBlocking

fun main() = runBlocking {
    val value = (1..10)
        .asFlow()
        .fold(10) { accumulator, value -> accumulator + value }
    println(value)
}