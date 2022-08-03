package dispatcher

import javafx.application.Application.launch
import kotlinx.coroutines.*
import kotlin.coroutines.coroutineContext


fun main() = runBlocking {
    val job = launch {
        launch(Job(this.coroutineContext[Job])) {
            println(coroutineContext.get(Job))
            println("launch1: ${Thread.currentThread().name}")
            delay(1000L)
            println("3!")
        }

        launch {
            println(coroutineContext[Job])
            println("launch2: ${Thread.currentThread().name}")
            delay(1000L)
            println("1!")
        }
    }

    delay(500L)
    job.cancelAndJoin()
    delay(1000L)
}
