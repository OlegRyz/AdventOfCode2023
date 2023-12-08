fun String.digits(
    usewords: Boolean = false,
    words: List<String> = listOf("zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine")
) = mapIndexed { index, char ->
    when {
        char.isDigit() -> char.digitToInt()
        usewords -> words.indexOfFirst {
            this@digits.regionMatches(
                thisOffset = index,
                other = it,
                otherOffset = 0,
                length = it.length,
                ignoreCase = true
            )
        }

        else -> -1
    }
}.filter { it != -1 }


fun String.integers() = integersIndexed().map { it.first }
fun String.integersIndexed() = Regex("[+-]?\\d+").findAll(this).map { it.value.toLong() to it.range }.toList()

fun String.tokens() = this.split(" ", ";", ",").filter { it.isNotBlank() }