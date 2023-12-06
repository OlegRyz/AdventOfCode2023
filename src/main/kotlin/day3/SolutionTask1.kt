package day3

import addPadding
import integersIndexed
import java.io.File

class SolutionTask1 {
    fun solve(path: String): Int {
        val lines = File("./src/main/kotlin/" +
                "${this::class.java.`package`.name}/$path").readLines()

        if (lines.isEmpty()) {
            return -1
        }
        return processLine(lines.addPadding('.'))
    }

    private fun processLine(lines: List<String>): Int {
        println("  alskdjf-1lskjd11-2".integersIndexed().map{(s, range) -> "($s, $range)"}.toList())
        val numbers = lines.mapIndexed { index, line ->
            line.integersIndexed().filter { (s, range) -> isAdjacent(index, range, lines) }
        }
        return numbers.flatMap { it.map { (s, _) -> s.toInt() } }.sumOf { it }
    }

    private fun isAdjacent(index: Int, range: IntRange, lines: List<String>): Boolean {
        return (lines[index][range.first - 1] != '.') ||
        (lines[index][range.last + 1] != '.') ||
                (lines[index - 1].substring(range.first - 1, range.last + 2).any { it != '.' }) ||
                (lines[index + 1].substring(range.first - 1, range.last + 2).any { it != '.' })
    }

}
