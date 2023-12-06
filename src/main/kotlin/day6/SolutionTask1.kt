package day6

import integers
import multiply
import java.io.File

class SolutionTask1 {
    fun solve(path: String): Int {
        val lines = File("./src/main/kotlin/day6/$path").readLines()
//        lines.forEach {
//            println(it)
//        }
        val times = lines[0].integers()
        val dists = lines[1].integers()
        println(times)
        val records = times.zip(dists).map {(time, dist) ->
            playGame(time, dist)
        }
        return records.multiply()
    }

    fun playGame(time: Long, dist: Long) = (0..time)
        .map { holdTime -> (time - holdTime) * holdTime }
        .count { it > dist }
    }
