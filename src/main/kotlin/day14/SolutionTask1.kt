package day14

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

        val list = emptyList<String>().toMutableList()
        var sum = 0L
        val platformSize = lines.size
        val load = ArrayList(List(lines.first().length) { 0 })
        lines.forEachIndexed { i, l ->
            l.forEachIndexed {j, c ->
                when (c) {
                    'O' -> {
                        sum += (platformSize - load[j])
                        load[j] += 1
                    }
                    '#' -> {
                        load[j] = i + 1
                    }
                }
            }

        }
        return sum
    }
}