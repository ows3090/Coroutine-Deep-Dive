package flow.context

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

fun log2(msg: String) = println("[${Thread.currentThread().name}] $msg")

fun simple2(): Flow<Int> = flow {// 플로우 내에서는 컨텍스트를 바꿀 수 없음 -> withContext(Dispatchers.Default Error
    for (i in 1..10) {
        delay(100L)
        log2("값 ${i}를 emit합니다")
        emit(i)
    } // 업스트림
}.flowOn(Dispatchers.IO) // 업스트림의 디스패처 결정
    .map { it*2 }
    .flowOn(Dispatchers.Default)


fun main(): Unit = runBlocking {
    launch(Dispatchers.IO) {
        simple2()
            .collect { value -> log("$value 를 받음") }
    }

}

