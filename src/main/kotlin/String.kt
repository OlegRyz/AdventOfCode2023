
fun String.digits(usewords: Boolean = false,
                  words: List<String> = listOf("zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine")
) = mapIndexed { index, c ->
    if (c.isDigit()) {
        c.digitToInt()
    } else if (usewords && words.any { this.substring(index).startsWith(it) }) {
        words.indexOfFirst { this.substring(index).startsWith(it) }
    } else {
        null
    }
}.filterNotNull()


fun String.integers() = this.split(regex = Regex("\\D")).mapNotNull { it.toIntOrNull() }

fun String.tokens() = this.split(" ", ";", ",").filter { it.isNotBlank() }