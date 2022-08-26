package flow.concat

import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.runBlocking

fun main() = runBlocking {
    // onEach action 수행 수 emit
    val strs = flowOf("일","이","삼").onEach {
        delay(200L)
        println("strs ${System.currentTimeMillis()}")
    }
    val nums = (1..3).asFlow().onEach {
        delay(100L)
        println("nums ${System.currentTimeMillis()}")
    }

    strs.combine(nums){ a, b -> "${a}은(는) $b"}
        .collect { println(it) }
}

