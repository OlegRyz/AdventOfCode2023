package day1

import java.io.File

class SolutionDay1Task1 {
    fun solve(): Int {
        val lines = File("./src/main/kotlin/day1/example1.txt").readLines()
        lines.forEach {
            println(it)
        }
        val result = lines.sumOf {
            ("" + it.first { it.isDigit() } + it.last{it.isDigit()}).toInt()
        }
        return result
    }

}