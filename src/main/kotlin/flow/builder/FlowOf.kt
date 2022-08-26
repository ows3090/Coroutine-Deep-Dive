package flow.builder

import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.flowOf
import kotlinx.coroutines.runBlocking


fun main() = runBlocking {
    flowOf(1,2,3,4,5).collect { value ->
        println(value)
    }
}