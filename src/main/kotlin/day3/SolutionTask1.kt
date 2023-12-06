package day3

import digits
import integers
import tokens
import java.io.File

class SolutionTask1 {
    fun solve(path: String): Int {
        val lines = File("./src/main/kotlin/" +
                "${this::class.java.`package`.name}/$path").readLines()
        if (lines.isEmpty()) {
            return -1
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
