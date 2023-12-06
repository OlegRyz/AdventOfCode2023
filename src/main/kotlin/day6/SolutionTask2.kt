package day6

import digits
import integers
import multiply
import java.io.File

class SolutionTask2 {
    fun solve(path: String): Int {
        val lines = File("./src/main/kotlin/day6/$path").readLines()
//        lines.forEach {
//            println(it)
//        }
        val times = lines[0].filter { it != ' ' }.split(":")
        val dists = lines[1].filter { it != ' ' }.split(":")
        println(times)

        return playGame(times[1].toLong(), dists[1].toLong())
    }

    fun playGame(time: Long, dist: Long) = (0..time)
        .map { holdTime -> (time - holdTime) * holdTime }
        .count { it > dist }
}


