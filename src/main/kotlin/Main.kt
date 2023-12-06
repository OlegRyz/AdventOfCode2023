import day6.SolutionTask1
import day6.SolutionTask2


fun main(args: Array<String>) {
    println("Ready set go!")
    val solution1 = SolutionTask1()
    println("Result of example1: ${solution1.solve("example1.txt")}")
    println("Result of task1: ${solution1.solve("task1.txt")}")
    val solution2 = SolutionTask2()
    println("Result of example1: ${solution2.solve("example1.txt")}")
    println("Result of task1: ${solution2.solve("task1.txt")}")
}