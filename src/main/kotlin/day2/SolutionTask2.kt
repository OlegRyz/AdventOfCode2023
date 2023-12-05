package day2

import digits
import integers
import java.io.File

class SolutionTask2 {
    fun solve(path: String): Int {
        val lines = File("./src/main/kotlin/day2/$path").readLines()
//        lines.forEach {
//            println(it)
//        }
        val ids = lines.map {
            playGame(it)
        }
        return ids.sumOf { it }
    }

    val cubes = mapOf("red" to 12, "green" to 13, "blue" to 14)
    private fun playGame(line: String): Int {
        val tokens = line.split(" ", ";", ",").filter { it.isNotBlank() }
        val res = cubes.keys.map { color ->
            val colors = tokens.withIndex().filter { it.value == color }.map { tokens[it.index - 1].toInt() }
            colors.max()
        }
        return res.map { it ?: 0 }.reduce() { acc, item -> acc * item }
    }
}

