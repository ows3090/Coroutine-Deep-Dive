package channel.pipe

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.cancelChildren
import kotlinx.coroutines.channels.ReceiveChannel
import kotlinx.coroutines.channels.produce
import kotlinx.coroutines.runBlocking

fun CoroutineScope.produceNumbers() = produce<Int> {
    var x = 1
    while(true){
        send(x++)
    }
}

fun CoroutineScope.produceStringNumbers(numbers: ReceiveChannel<Int>): ReceiveChannel<String> = produce {
    for(i in numbers){
        send("${i}!")
    }
}

fun main() = runBlocking {
    val numbers = produceNumbers()
    val stringNumbers = produceStringNumbers(numbers)

    repeat(5){
        println(stringNumbers.receive())
    }
    println("완료")
    coroutineContext.cancelChildren()
}