package basic.builder

import kotlinx.coroutines.runBlocking


fun main() = runBlocking {
    println(Thread.currentThread().name)
    println("Hello")
}