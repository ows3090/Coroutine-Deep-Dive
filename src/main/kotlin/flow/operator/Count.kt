package flow.operator

import kotlinx.coroutines.flow.asFlow
import kotlinx.coroutines.flow.count
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

fun main() = runBlocking {
    val counter = (1..10)
        .asFlow()
        .count{ // terminal operator : 바로 값을 가져올 수 있음
            it % 2 == 0
        }
    println(counter)
}