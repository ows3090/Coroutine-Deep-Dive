package basic.builder

import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

fun main(){
    runBlocking {
        launch {
            println("launch1 : ${Thread.currentThread().name}")
            delay(1000L)
            println("3!")
        }

        launch {
            println("launch2 : ${Thread.currentThread().name}")
            println("1!")
        }

        println("runBlocking : ${Thread.currentThread().name}")
        delay(500L)
        println("2!")
    }
    println("4!")
}