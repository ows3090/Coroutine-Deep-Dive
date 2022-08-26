package flow.builder

import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.withTimeoutOrNull
import kotlin.random.Random

fun flowSomething2(): Flow<Int> = flow {
    repeat(10){
        emit(Random.nextInt(0, 500))
        delay(100L)
    }
}


fun main() = runBlocking {
    val result = withTimeoutOrNull(500L){
        flowSomething2().collect { value ->
            println(value)
        }
        true
    }?: false
    println(result)
}