package channel.fan

import kotlinx.coroutines.cancelChildren
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

suspend fun someone(channel: Channel<String>, name: String){
    for(comment in channel){
        println("${name}: ${comment}")
        channel.send(comment.drop(1) + comment.first())
        delay(1000)
    }
}

fun main() = runBlocking {
    val channel = Channel<String>()
    launch {
        someone(channel, "민준")
    }

    launch {
        someone(channel, "서연")
    }

    channel.send("패스트 캠퍼스")
    delay(1000L)
    coroutineContext.cancelChildren()
}