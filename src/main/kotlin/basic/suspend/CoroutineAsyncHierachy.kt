package basic.suspend

import kotlinx.coroutines.async
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.runBlocking
import kotlin.random.Random

suspend fun getRandom5(): Int{
    try{
        delay(1000L)
        return Random.nextInt(0, 500)
    }finally {
        println("getRandom1 is cancelled.")
    }
}

suspend fun getRandom6(): Int{
    delay(500L)
    throw IllegalStateException()
}

suspend fun doSomething() = coroutineScope {
    val value1 = async { getRandom5() }
    val value2 = async { getRandom6() }
    try{
        println("${value1.await()} + ${value2.await()} = ${value1.await() + value2.await()}")
    }finally {
        println("doSomething is cancelled.")
    }
}

fun main() = runBlocking {
    try{
        doSomething()
    }catch (e: IllegalStateException){
        println("doSomething failed: $e")
    }
}