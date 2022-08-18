package basic.cancel_timeout

import kotlinx.coroutines.*

suspend fun doCount3() = coroutineScope {
    val job1 = launch(Dispatchers.Default) {
        var i = 1
        var nextTime = System.currentTimeMillis() + 100L

        while(i <= 10 && isActive){
            val currentTime = System.currentTimeMillis()

            if(currentTime >= nextTime){
                println(i)
                nextTime = currentTime + 100L
                i++
            }
        }
    }
}

fun main() = runBlocking {
    val result = withTimeoutOrNull(1500L){
        doCount3()
        true
    } ?: false
    println(result)
}