package day2

import digits
import integers
import java.io.File

class SolutionTask1 {
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
        return if (tokens.withIndex().any {
                val allowed = cubes.getOrDefault(it.value, -1)
                (allowed > 0 && allowed < tokens[it.index - 1].toInt())
            }) {
            0
        } else {
            line.integers().first()
        }

    }

}