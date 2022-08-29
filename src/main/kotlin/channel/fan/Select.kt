package channel.fan

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.cancelChildren
import kotlinx.coroutines.channels.produce
import kotlinx.coroutines.delay
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.selects.select

fun CoroutineScope.sayFast() = produce<String> {
    while(true){
        delay(100L)
        send("패스트")
    }
}

fun CoroutineScope.sayCampus() = produce<String> {
    while(true){
        delay(150L)
        send("캠퍼스")
    }
}

fun main() = runBlocking {
    val fasts = sayFast()
    val campuses = sayCampus()
    repeat(5){
        select {
            fasts.onReceive{
                println("fast: $it")
            }
            campuses.onReceive{
                println("campus: $it")
            }
        }
    }
    coroutineContext.cancelChildren()
}