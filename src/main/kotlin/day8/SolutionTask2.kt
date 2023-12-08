package day8

import leastCommonMultiple
import java.io.File


class SolutionTask2 {
    fun solve(path: String): Long {
        val lines = File(
            "./src/main/kotlin/" +
                    "${this::class.java.`package`.name}/$path"
        ).readLines()

        if (lines.isEmpty()) {
            return -1
        }

        val instructions = lines.first().map { "LR".indexOf(it) }


        val nodes = lines.takeLast(lines.size - 2).associate {
            it.substring(0, 3) to Node(it.substring(7, 10), it.substring(12, 15))
        }
        return process(nodes, instructions)
    }

    data class Node(val left: String, val right: String) {
        fun doStep(instruction: Int) = listOf(left, right)[instruction]
    }

    private fun process(network: Map<String, Node>, instructions: List<Int>): Long {
        val startingPoints = network.keys.filter { it.endsWith('A') }
        val allLoopLengths = startingPoints.map { loopLength(it, network, instructions) }
        return allLoopLengths.leastCommonMultiple() //Input data is built that loop length is equal to length from AAA to ZZZ.
    }

    private fun loopLength(
        first: String,
        network: Map<String, Node>,
        instructions: List<Int>,
    ): Long {
        var current = first
        var i = 0
        while (!current.endsWith('Z')) {
            current = network[current]!!.doStep(instructions[(i % instructions.size)])
            i++
        }
        return i.toLong()
    }


}
