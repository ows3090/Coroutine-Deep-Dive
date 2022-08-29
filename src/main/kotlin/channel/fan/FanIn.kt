package channel.fan

import kotlinx.coroutines.*
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.channels.ReceiveChannel
import kotlinx.coroutines.channels.SendChannel
import kotlinx.coroutines.channels.consumeEach

suspend fun produceNumbers(channel: SendChannel<Int>, from: Int, interval: Long){
    var x = from
    while(true){
        channel.send(x)
        x+=2
        delay(interval)
    }
}

fun CoroutineScope.processNumber(channel: ReceiveChannel<Int>) = launch {
    channel.consumeEach {
        println("${it}을 받았습니다.")
    }
}

fun main() = runBlocking {
    val channel = Channel<Int>()
    launch {
        produceNumbers(channel, 1, 100L)
    }

    launch {
        produceNumbers(channel, 2, 150L)
    }
    processNumber(channel)
    delay(1000L)
    coroutineContext.cancelChildren()
}