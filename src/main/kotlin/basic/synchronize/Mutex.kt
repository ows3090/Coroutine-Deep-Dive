package basic.synchronize

import kotlinx.coroutines.*
import kotlinx.coroutines.sync.Mutex
import kotlinx.coroutines.sync.withLock
import java.util.concurrent.atomic.AtomicInteger
import kotlin.system.measureTimeMillis

suspend fun massiveRun2(action: suspend () -> Unit) {
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

var counter2 = 0
val mutex = Mutex()

fun main() = runBlocking {
    withContext(Dispatchers.IO){
        massiveRun2 {
            mutex.withLock {
                counter2++
            }
        }
    }
    println("Counter = $counter2")
}