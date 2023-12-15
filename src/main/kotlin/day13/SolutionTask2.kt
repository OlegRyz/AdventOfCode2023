package day13

import println
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

        val list = emptyList<String>().toMutableList()
        var sum = 0L
        for (i in lines.indices) {
            if (lines[i].isEmpty()) {
                sum +=process(list)
                list.clear()
            } else {

                list.add(lines[i])
            }
        }
        return sum
    }

    private fun process(list: List<String>): Long {
        list.println()
        return (horMirror(list) + 100*vertMirror(list)).also { println(it) }
    }

    private fun vertMirror(list: List<String>): Long {
        var result = 0L
        for (i in 1 ..< list.size) {
            var unmatches = 0
            var k = i
            for (j in i - 1 downTo 0) {
                if (unmatches > 1 || k >= list.size) {
                    break
                }
                unmatches += list[j].withIndex() .count{ (index, c) -> c != list[k][index] }
                k++
            }
            if (unmatches == 1) {
                result = i.toLong()
                break
            }
        }
        return result
    }

    private fun horMirror(list: List<String>): Long {
        var result = 0L
        for (i in 1 ..< list.first().length) {
            var unmatches = 0
            var k = i
            for (j in i - 1 downTo 0) {
                if (unmatches > 1 || k >= list.first().length) {
                    break
                }
                unmatches += list.count { it[j] != it[k]}
                k++
            }
            if (unmatches == 1) {
                result = i.toLong()
                break
            }
        }
        return result
    }

}