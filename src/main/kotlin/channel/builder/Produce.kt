package channel.builder

import kotlinx.coroutines.channels.consumeEach
import kotlinx.coroutines.channels.produce
import kotlinx.coroutines.runBlocking

fun main() = runBlocking {
    val oneToTen = produce<Int> {
        for(x in 1..10){
            send(x)
        }
    }

    oneToTen.consumeEach {
        println(it)
    }
    println("완료")
}