package flow.concat

import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.runBlocking

fun main() = runBlocking {
    val nums = (1..3).asFlow()
    val strs = flow<String>{
        emit("일")
        delay(100)
        emit("이")
        delay(100)
        emit("삼")
    }
    nums.zip(strs){ a,b -> "${a}은(는) $b"}
        .collect { println(it) }
}