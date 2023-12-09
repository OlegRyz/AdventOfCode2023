package day2

import digits
import integers
import tokens
import java.io.File
import kotlin.io.path.Path
import kotlin.io.path.readLines

class SolutionTask1 {
    fun solve(path: String): Int {
        val lines = File("./src/main/kotlin/day2/$path").readLines()
        val lines2 = Path("./src/main/kotlin/day2/$path").readLines()
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
        val tokens = line.tokens()
        return if (tokens.withIndex().any {
                val allowed = cubes.getOrDefault(it.value, -1)
                (allowed > 0 && allowed < tokens[it.index - 1].toInt())
            }) {
            0
        } else {
            line.integers().first().toInt()
        }

    }

}
