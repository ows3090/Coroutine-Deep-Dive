package flow.operator

import kotlinx.coroutines.flow.asFlow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.filter
import kotlinx.coroutines.flow.filterNot
import kotlinx.coroutines.runBlocking

fun main() = runBlocking {
    (1..20).asFlow().filterNot {
        it % 2 == 0
    }.collect {
        println(it)
    }
}