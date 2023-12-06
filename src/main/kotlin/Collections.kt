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

fun List<String>.addPadding(char: Char): List<String> {
    val mutable = this.map { "${char}$it${char}" }.toMutableList()
    val row = buildString(mutable.first().length) {
        repeat(mutable.first().length) {
            append(char)
        }
    }
    mutable.add(0, row)
    mutable.add(row)
    return mutable.toList()
}