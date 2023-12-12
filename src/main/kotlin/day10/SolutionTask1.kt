package day10

import addPadding
import java.io.File

class SolutionTask1 {
    val commands = mapOf(
    "|" to listOf(-1, 0, 1, 0),// is a vertical pipe connecting north and south.
    "-" to listOf(0, -1, 0, 1),// is a horizontal pipe connecting east and west.
    "L" to listOf(-1, 0, 0, 1),// is a 90-degree bend connecting north and east.
    "J" to listOf(0, -1, -1, 0),// is a 90-degree bend connecting north and west.
    "7" to listOf(0, -1, 1, 0),// is a 90-degree bend connecting south and west.
    "F" to listOf(1, 0, 0, 1),// is a 90-degree bend connecting south and east.
    "." to listOf(0, 0, 0, 0),// is ground; there is no pipe in this tile.
    "S" to listOf(0, 0, 0, 0),// is the starting position of the animal; there is a pipe on this tile, but your sketch doesn't show what shape the pipe has.
    )
    fun solve(path: String): Long {
        val lines = File(
            "./src/main/kotlin/" +
                    "${this::class.java.`package`.name}/$path"
        ).readLines()

        if (lines.isEmpty()) {
            return -1
        }

        return processLines(lines.addPadding('.'))
    }

    private fun processLines(values: List<String>): Long {
        val startY = values.indexOfFirst { it.contains("S") }
        val startX = values[startY].indexOfFirst { it == 'S' }
        println("$startY, $startX")
        val linst = start(listOf(startY, startX), values)
        println(linst)
        var left = linst[0]
        var right = linst[1]
        var l = 0L
        var previousLeft = listOf(startY, startX)
        var previousRight = listOf(startY, startX)
        while (left != right && left != previousRight && right != previousLeft) {
            val t1 = left
            val t2 = right
            left = next(left, previousLeft, values)
            right = next(right, previousRight, values)
            previousLeft = t1
            previousRight = t2
            l++
        }
        return l + 1
    }

    private fun start(start: List<Int>, values: List<String>): List<List<Int>> {
        val result = mutableListOf<List<Int>>()
        for (i in -1..1) {
            for (j in -1..1) {
                if (i == 0 && j==0) continue
                val pipeRepr = commands[values[start[0] + i][start[1] + j].toString()]!!
                if (((pipeRepr[0] == -i) && (pipeRepr[1] == -j)) || (pipeRepr[2] == -i) && (pipeRepr[3] == -j)) {
                    result.add(listOf(start[0] + i, start[1] + j))
                }
            }
        }
        return result
    }

    private fun next(start: List<Int>, previous: List<Int>, values: List<String>): List<Int> {
        val pipe = values[start[0]][start[1]]
        val pipeRepr = commands[pipe.toString()]!!
        val left = listOf(start[0] + pipeRepr[0], start[1] + pipeRepr[1])
        val right = listOf(start[0] + pipeRepr[2], start[1] + pipeRepr[3])
        return if (left != previous) left
        else right
    }
}