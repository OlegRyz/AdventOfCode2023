fun greatestCommonDivider(a: Long, b: Long): Long {
    return when (b) {
        0L -> a
        else -> greatestCommonDivider(b, a % b)
    }
}

fun List<Long>.leastCommonMultiple() = this.reduce { lcm, x -> lcm * x / greatestCommonDivider(lcm, x) }
