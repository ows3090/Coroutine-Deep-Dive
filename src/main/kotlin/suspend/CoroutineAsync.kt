package suspend

import kotlinx.coroutines.async
import kotlinx.coroutines.delay
import kotlinx.coroutines.runBlocking
import kotlin.random.Random
import kotlin.system.measureTimeMillis

suspend fun getRandom3(): Int {
    delay(1000L)
    return Random.nextInt(0, 500)
}

suspend fun getRandom4(): Int {
    delay(1000L)
    return Random.nextInt(0, 500)
}

fun main() = runBlocking {
    val elapsedTime = measureTimeMillis {
        val value1 = async { getRandom3() }
        val value2 = async { getRandom4() }
        println("${value1.await()} + ${value2.await()} = ${value1.await() + value2.await()}")
    }

    println(elapsedTime)
}