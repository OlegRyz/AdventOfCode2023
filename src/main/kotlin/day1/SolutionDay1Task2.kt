package day1

import digits
import java.io.File
import java.lang.Exception

class SolutionDay1Task2 {
    fun solve(path: String): Int {
        val lines = File(path).readLines()
//        lines.forEach {
//            println(it)
//        }
        val result = lines.sumOf {
            (it.findFirstDigit() * 10 + it.findLastDigit())
        }
        return result
    }
    fun String.findFirstDigit() = this.digits(usewords = true).first()
    fun String.findLastDigit() = this.digits(usewords = true).last()

}

