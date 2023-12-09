package day9

import integers
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

        return lines.sumOf {
            processLine(it.integers())
        }
    }

    private fun processLine(values: List<Long>): Long = when (values.all { x -> x == 0L }) {
        true -> 0
        else -> values.last() + processLine(
            buildList {
                for (i in 1..<values.size) {
                    add(values[i] - values[i - 1])
                }
            })
    }
}