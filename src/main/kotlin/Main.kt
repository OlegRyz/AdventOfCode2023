import day1.SolutionDay1Task1
import day1.SolutionDay1Task2

fun main(args: Array<String>) {
    println("Ready set go!")
    val solution1 = SolutionDay1Task1()
    println("Result of example1: ${solution1.solve("./src/main/kotlin/day1/example1.txt")}")
    println("Result of task1: ${solution1.solve("./src/main/kotlin/day1/task1.txt")}")
    val solution2 = SolutionDay1Task2()
    println("Result of example1: ${solution2.solve("./src/main/kotlin/day1/example2.txt")}")
    println("Result of task1: ${solution2.solve("./src/main/kotlin/day1/task1.txt")}")
}