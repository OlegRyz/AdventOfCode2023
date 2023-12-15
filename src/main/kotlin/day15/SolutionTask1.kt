package day15

import println
import java.io.File

class SolutionTask1 {

    fun solve(path: String): Long {

        val lines = File(
            "./src/main/kotlin/" +
                    "${this::class.java.`package`.name}/$path"
        ).readLines()

        if (lines.isEmpty()) {
            return -1
        }
        var sum = 0L
        lines.forEach {

            val split = it.split(',')
            sum += split.sumOf { it.fold(0L) { current, c ->
                (current + c.code) * 17 % 256
            }}
        }

        return sum
    }
}