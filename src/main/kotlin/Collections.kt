import java.math.BigDecimal
import java.math.BigInteger

fun Iterable<Int>.multiply() = this.reduce { acc, x -> x * acc }
fun Iterable<Long>.multiply() = this.reduce { acc, x -> x * acc }
fun Iterable<BigDecimal>.multiply() = this.reduce { acc, x -> x * acc }
fun Iterable<BigInteger>.multiply() = this.reduce { acc, x -> x * acc }
fun Iterable<Float>.multiply() = this.reduce { acc, x -> x * acc }
fun Iterable<Double>.multiply() = this.reduce { acc, x -> x * acc }