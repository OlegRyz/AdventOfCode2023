package day8

import java.io.File

class SolutionTask1 {
    fun solve(path: String): Long {
        val lines = File("./src/main/kotlin/" +
                "${this::class.java.`package`.name}/$path").readLines()

        if (lines.isEmpty()) {
            return -1
        }

        val instructions = lines.first().map {
            when(it) {
                'L'->0
                'R'->1
                else -> null
            }
        }.filterNotNull()


        val nodes = lines.takeLast(lines.size - 2).map {
            it.substring(0,3) to Node(it.substring(7,10), it.substring(12,15))
        }.toMap()
        return processLine(nodes, instructions)
    }

    data class Node(val left: String, val right: String) {
        fun next(instruction: Int) = if (instruction == 0) left else right
    }

    private fun processLine(network: Map<String, Node>, instructions: List<Int>): Long {
        println(network)
        var current = "AAA";
        var i = 0
        while(current != "ZZZ") {
            current = network[current]!!.next(instructions[i%instructions.size])
            i++
        }
        return i.toLong()
    }

}
