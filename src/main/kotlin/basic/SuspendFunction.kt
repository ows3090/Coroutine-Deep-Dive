package basic

import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

fun doOne(){
    println("launch1: ${Thread.currentThread().name}")
    println("1!")
}

suspend fun doTwo(){
    println("launch2: ${Thread.currentThread().name}")
    delay(500L)
    println("2!")
}

suspend fun doThree(){
    println("launch3: ${Thread.currentThread().name}")
    delay(1000L)
    println("3!")
}


// runBlocking 리턴값을 명시적으로 지정할 필요가 있을 때는 Unit 호출
fun main() = runBlocking<Unit> {
    launch {
        doThree()
    }

    launch {
        doOne()
    }

    doTwo()
}