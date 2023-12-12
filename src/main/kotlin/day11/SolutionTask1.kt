package day11

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

        val gal = findGalaxies(lines)
        val exGal = expandGal(gal)
        val dists = distances(exGal)
        return dists

    }

    private fun distances(exGal: List<Pair<Int, Int>>): Long {
        var sum = 0L
        for (i in exGal.indices) {
            for (j in exGal.indices.filter { it > i }) {
                val dist = Math.abs(exGal[i].first - exGal[j].first) + Math.abs(exGal[i].second - exGal[j].second)
                sum += dist
            }
        }
        return sum
    }

    private fun expandGal(gal: List<Pair<Int, Int>>): List<Pair<Int, Int>> {
        val allY = buildSet {
            gal.forEach { add(it.first) }
        }
        val allX = buildSet {
            gal.forEach { add(it.second) }
        }
        val maxY = allY.max()
        val maxX = allX.max()
        val expY = buildSet { (0..maxY).forEach { if (it !in allY) add(it) } }
        val expX = buildSet { (0..maxX).forEach { if (it !in allX) add(it) } }
        println(expY)
        println(expX)
        return buildList {
            gal.forEach { galaxy ->
                val y = galaxy.first + expY.count { it < galaxy.first }
                val x = galaxy.second + expX.count { it < galaxy.second }
                add(y to x)
            }
        }
    }


    private fun findGalaxies(lines: List<String>): List<Pair<Int, Int>> = lines.flatMapIndexed { y, row ->
        row.withIndex().filter { char ->
            char.value == '#'
        }.map { y to it.index }
    }

}