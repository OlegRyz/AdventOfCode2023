package day13

import println
import java.io.File

class SolutionTask1 {

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
            var isMirror = true
            var k = i
            for (j in i - 1 downTo 0) {
                if (k >= list.size) {
                    break
                }
                isMirror = isMirror && (list[j]==list[k])
                k++
            }
            if (isMirror) {
                result = i.toLong()
                break
            }
        }
        return result
    }

    private fun horMirror(list: List<String>): Long {
        var result = 0L
        for (i in 1 ..< list.first().length) {
            var isMirror = true
            var k = i
            for (j in i - 1 downTo 0) {
                if (!isMirror || k >= list.first().length) {
                    break
                }
                isMirror = isMirror && (list.all { it[j] == it[k]})
                k++
            }
            if (isMirror) {
                result = i.toLong()
                break
            }
        }
        return result
    }

}