package flow.exception

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.runBlocking

fun simple(): Flow<Int> = flow {
    for(i in 1..3){
        println("Emitting $i")
        emit(i)
    }
}

fun main() = runBlocking {
    try{
        simple().collect { value ->
            println(value)
            check(value <=1){"Collected ${value}"}
        }
    }catch (e: Throwable){
        println("Caught $e")
    }
}