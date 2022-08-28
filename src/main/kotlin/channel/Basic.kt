package channel

import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

fun main() = runBlocking {
    val channel = Channel<Int>()
    launch {
        for(x in 1..10){
            channel.send(x)
        }
    }

    repeat(10){
        println(channel.receive())
    }
    println("완료")
}