package flow.exception

import kotlinx.coroutines.flow.*
import kotlinx.coroutines.runBlocking

fun simple3(): Flow<String> =
    flow {
        for(i in 1..3){
            println("Emitting $i")
            emit(i)
        }
    }.map { value ->
        check(value <= 1) {"Crashed on $value"}
        "string $value"
    }

fun main() = runBlocking {
    try{
        simple3()
            .catch { e -> emit("Caught $e") }
            .collect { value -> println(value) }
    }catch (e: Throwable){
        println("Caught $e")
    }
}