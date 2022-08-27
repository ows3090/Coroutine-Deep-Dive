package flow.launch

import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.runBlocking

fun events2(): Flow<Int> = (1..3).asFlow().onEach { delay(100) }

fun main() = runBlocking {
    events2()
        .onEach {event ->
            println("Event: $event ${Thread.currentThread().name}")
        }
        .launchIn(this)
    println("Done ${Thread.currentThread().name}")
}