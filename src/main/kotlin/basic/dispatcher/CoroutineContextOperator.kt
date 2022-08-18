package basic.dispatcher

import kotlinx.coroutines.*


@ExperimentalStdlibApi
fun main() = runBlocking<Unit> {
    launch {
        launch(Dispatchers.IO + CoroutineName("launch1")) {
            println("launch1: ${Thread.currentThread().name}")
            println(coroutineContext[CoroutineDispatcher])
            println(coroutineContext[CoroutineName])
            delay(5000L)
        }

        launch(Dispatchers.Default + CoroutineName("launch1")) {
            println("launch2: ${Thread.currentThread().name}")
            println(coroutineContext[CoroutineDispatcher])
            println(coroutineContext[CoroutineName])
            delay(10L)
        }
    }
}