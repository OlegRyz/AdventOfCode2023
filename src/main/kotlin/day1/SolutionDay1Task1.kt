package day1

import digits
import java.io.File

class SolutionDay1Task1 {
    fun solve(path: String): Int {
        val lines = File("./src/main/kotlin/day1/$path").readLines()
//        lines.forEach {
//            println(it)
//        }
        val result = lines.sumOf {
            ("" + it.digits().first() + it.digits().last()).toInt()
        }
        return result
    }

}