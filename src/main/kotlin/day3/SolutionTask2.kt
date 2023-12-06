package day3

import digits
import integers
import java.io.File

class SolutionTask2 {
    fun solve(path: String): Int {
        val lines = File("./src/main/kotlin/" +
                "${this::class.java.`package`.name}/$path").readLines()
        if (lines.isEmpty()) {
            return -1
        }
        lines.forEach {
            println(it)
        }
        val ids = lines.map {
            processLine(it)
        }
        return ids.sumOf { it }
    }

    private fun processLine(line: String): Int {
        val res = 0
        return res
    }
}

