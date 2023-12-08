package day7

import java.io.File

class SolutionTask1 {
    fun solve(path: String): Long {
        val lines = File("./src/main/kotlin/" +
                "${this::class.java.`package`.name}/$path").readLines()

        if (lines.isEmpty()) {
            return -1
        }

        val items = lines.map {
            val tokens = it.split(' ')
            Hand(tokens[0], tokens[1].toLong())
        }
        return processLine(items)
    }

    data class Hand(val cards:String, val points:Long)

    private fun processLine(hands: List<Hand>): Long {
        val sorted = hands.sortedBy {
            it.cards.combinations() * 1000_000_000 + it.cards.highest()
        }
        println(sorted)
        println(sorted.map { it.cards.combinations() * 1000_000000 + it.cards.highest() })
        val t =  sorted.foldIndexed(0) { index, acc: Long, hand ->
            acc + hand.points * (index + 1)
        }
        return t
    }

    private fun String.combinations() = this.groupBy { it }.map { it.value }.map { Math.pow(5.0, it.size.toDouble()) }.sum()

    val cards = listOf("A", "K", "Q", "J", "T", "9", "8", "7", "6", "5", "4", "3", "2").reversed()
    private fun String.highest(): Double  = reversed().mapIndexed { index, c: Char ->
        Math.pow(cards.size.toDouble(), index.toDouble()) * cards.indexOf(c.toString()) }
        .sumOf { it }

}
