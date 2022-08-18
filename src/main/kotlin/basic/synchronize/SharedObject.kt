package basic.synchronize

import kotlinx.coroutines.*
import java.util.concurrent.atomic.AtomicInteger
import kotlin.system.measureTimeMillis

suspend fun massiveRun(action: suspend () -> Unit) {
    val n = 100
    val k = 1000
    val elapsed = measureTimeMillis {
        coroutineScope {
            repeat(n) {
                launch {
                    repeat(k) { action() }
                }
            }
        }
    }
    println("$elapsed ms동안 ${n*k}개의 액션을 수행했습니다.")
}

@Volatile
var counter = AtomicInteger()

fun main() = runBlocking {
    withContext(Dispatchers.IO){
        massiveRun {
            counter.incrementAndGet()
        }
    }
    println("Counter = $counter")
}