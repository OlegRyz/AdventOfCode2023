import java.math.BigDecimal
import java.math.BigInteger

fun Iterable<Int>.multiply() = this.reduce { acc, x -> x * acc }
fun Iterable<Long>.multiply() = this.reduce { acc, x -> x * acc }
fun Iterable<BigDecimal>.multiply() = this.reduce { acc, x -> x * acc }
fun Iterable<BigInteger>.multiply() = this.reduce { acc, x -> x * acc }
fun Iterable<Float>.multiply() = this.reduce { acc, x -> x * acc }
fun Iterable<Double>.multiply() = this.reduce { acc, x -> x * acc }
fun Sequence<Int>.multiply() = this.reduce { acc, x -> x * acc }
fun Sequence<Long>.multiply() = this.reduce { acc, x -> x * acc }
fun Sequence<BigDecimal>.multiply() = this.reduce { acc, x -> x * acc }
fun Sequence<BigInteger>.multiply() = this.reduce { acc, x -> x * acc }
fun Sequence<Float>.multiply() = this.reduce { acc, x -> x * acc }
fun Sequence<Double>.multiply() = this.reduce { acc, x -> x * acc }

fun List<String>.addPadding(char: Char) = addHorizontalPadding(char).addVerticalPadding(char)

fun List<String>.addHorizontalPadding(char: Char) = this.map { "$char$it$char" }

fun List<String>.addVerticalPadding(char: Char) = toMutableList().apply {
    val paddingRow = buildString(first().length, char)
    add(0, paddingRow)
    add(paddingRow)
}.toList()

fun buildString(length: Int, char: Char) = buildString(length) {
    repeat(length) {
        append(char)
    }
}