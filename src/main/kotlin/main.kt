import kotlinx.coroutines.coroutineScope

fun main(args: Array<String>) {
    val numbers = intArrayOf()
    numbers.mapIndexed { index, i ->  }
    numbers.foldIndexed(0){ index, acc, i ->
        acc + index
    }
    numbers.fold(listOf(0)){list, i ->
        list.run {
            map { it + i }
        }
    }
}