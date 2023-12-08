fun greatestCommonDivider(a: Long, b: Long): Long {
    var a1 = a
    var b1 = b
    while(b1 != 0L) {
        val swap = b1
        b1 = a1 % b1
        a1 = swap
    }
    return a1
}

fun List<Long>.leastCommonMultiple() = this.reduce { lcm, x -> lcm * x / greatestCommonDivider(lcm, x) }
