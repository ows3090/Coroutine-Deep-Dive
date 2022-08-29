package channel.buffer

import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

fun main() = runBlocking {
    val channel = Channel<Int>(Channel.CONFLATED)
    launch {
        for(x in 1..20){
            println("${x} 전송중")
            channel.send(x)
        }
        channel.close()
    }

    for(x in channel){
        println("${x} 수신")
        delay(100L)
    }
    println("완료")
}