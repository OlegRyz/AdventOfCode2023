
fun <E> List<E>.println() = this.also { forEach { println(it) } }