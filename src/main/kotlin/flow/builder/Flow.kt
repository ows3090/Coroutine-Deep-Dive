package flow.builder

import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.runBlocking
import kotlin.random.Random

fun flowSomething(): Flow<Int> = flow {
    repeat(10){
        emit(Random.nextInt(0, 500))
        delay(10L)
    }
}

fun main() = runBlocking {
    flowSomething().collect { value ->
        println(value)
    }
}