package day15

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
        val container = buildList<ArrayList<Pair<String, Int>>> { repeat(256) { add(ArrayList<Pair<String, Int>>())} }.toMutableList()
        lines.first().split(',').forEach {
            when {
                it.contains('-') -> {
                    val key = it.split('-').first()
                    val bucket = container[hash(key)]
                    val index = bucket.indexOfFirst { it.first == key }
                    if (index >= 0) {
                        bucket.removeAt(index)

                    }
                }
                it.contains('=') -> {
                    val split = it.split('=')
                    val key = split.first()
                    val value = split[1]
                    val bucket = container[hash(key)]
                    val index = bucket.indexOfFirst { it.first == key }
                    if (index < 0){
                        bucket.add(key to value.toInt())
                    } else {
                        bucket[index] = key to (value.toInt())
                    }
                }

            }
        }
        return container.withIndex().sumOf { (index, value) ->
            (index + 1) * value.withIndex().sumOf { (j, v)->
                (j + 1) *v.second
            }
        }.toLong()
    }

    private fun hash(line: String): Int {
        var sum = 0

        val split = line.split(',')
        sum += split.sumOf {
            line.fold(0) { current, c ->
                (current + c.code) * 17 % 256
            }.toInt()
        }
        return sum
    }
}