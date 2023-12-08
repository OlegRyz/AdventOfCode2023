package day7

import java.io.File
import java.math.BigDecimal
import java.math.BigInteger

class SolutionTask2 {
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
        val sorted = hands.sortedWith { c1, c2 ->
            if (c1.cards.combinations() > c2.cards.combinations()) {
                1
            } else if(c1.cards.combinations() < c2.cards.combinations()) {
                -1
            } else {
                if (c1.cards.highest() > c2.cards.highest()) {
                    1
                } else if (c1.cards.highest() < c2.cards.highest()) {
                    -1
                } else {
                    0
                }
            }
        }
        println(sorted)
        println("***********************************************************************")
        sorted.map { (it.cards.combinations() to it.cards.highest().toBigDecimal()) to it }
            .forEach {
                println(it)
            }
        println( )
        val t =  sorted.foldIndexed(0) { index, acc: Long, hand ->
            acc + hand.points * (index + 1)
        }
        return t
    }

    private fun String.combinations(): Int {
        val groups = this.groupBy { it }.map { it.value }.sortedBy { it.size }.toMutableList()
        val jokers = groups.firstOrNull { it.contains('J') }
        if (jokers != null) {
            groups.remove(jokers)
            val (j, s) = if (groups.isNotEmpty()) {
                val s = groups.last().size
                val j = groups.last()[0]
                groups.removeLast()
                (j to s)
            } else {
                ('A' to 0)
            }

            groups.add( List(s + jokers.size) {j})
        }
        return when {
            groups.maxOf { it.size } == 5 -> 6
            groups.maxOf { it.size } == 4 -> 5
            groups.maxOf { it.size } == 3 && groups.any { it.size == 2 } -> 4
            groups.maxOf { it.size } == 3 && groups.any { it.size != 2 } -> 3
            groups.count { it.size  == 2 } == 2 -> 2
            groups.count { it.size  == 2 } == 1 -> 1
            else -> 0
        }
    }


    val cards = listOf("A", "K", "Q", "T", "9", "8", "7", "6", "5", "4", "3", "2", "J").reversed()
    private fun String.highest(): Double  = reversed().mapIndexed { index, c: Char ->
        Math.pow(cards.size.toDouble(), index.toDouble()) * cards.indexOf(c.toString()) }
        .sumOf { it }

}
