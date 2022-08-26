package flow.buffer

import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.runBlocking
import kotlin.system.measureTimeMillis

fun simple4(): Flow<Int> = flow{
    for(i in 1..3){
        delay(100)
        emit(i)
    }
}

fun main() = runBlocking {
    val time = measureTimeMillis {
        simple4().collectLatest { value ->
            println("값 ${value}를 처리하기 시작합니다")
            delay(300)
            println(value)
            println("처리를 완료하였습니다.")
        }
    }
    println("Collected in ${time} ms")
}