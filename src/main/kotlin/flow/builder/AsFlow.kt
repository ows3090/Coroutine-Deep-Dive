package flow.builder

import kotlinx.coroutines.flow.asFlow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.runBlocking


fun main() = runBlocking {
    listOf(1,2,3,4,5).asFlow().collect {value ->
        println(value)
    }

    (6..10).asFlow().collect {value ->
        println(value)
    }
}