fun main() {
    data class Stats(val trueBits: Array<Int>, val falseBits: Array<Int>) {
        constructor(size: Int) : this(Array(size) { 0 }, Array(size) { 0 })

        fun valueAtIndex(i: Int, c: Char) {
            when (c) {
                '1' -> trueBits[i] = trueBits[i] + 1
                '0' -> falseBits[i] = falseBits[i] + 1
                else -> throw IllegalStateException()
            }
        }

        fun gamma(): Int {
            return trueBits.zip(falseBits)
                .map { it.first > it.second }
                .map { bool -> if (bool) '1' else '0' }
                .joinToString(separator = "").toInt(2)
        }

        fun epsilon(): Int {
            return trueBits.zip(falseBits)
                .map { it.first < it.second }
                .map { bool -> if (bool) '1' else '0' }
                .joinToString(separator = "").toInt(2)
        }

        fun result(): Int = gamma() * epsilon()
    }

    fun part1(input: List<String>): Int {
        val length = input[0].length
        val stats = Stats(length)
        input.forEach { s ->
            s.toCharArray().forEachIndexed(stats::valueAtIndex)
        }
        return stats.result()
    }

    fun part2(input: List<String>): Int {

        TODO()
    }

    // test if implementation meets criteria from the description, like:
    val testInput = readInput("Day03_test")
    check(part1(testInput) == 198)
//    check(part2(testInput) == 900)

    val input = readInput("Day03")
    println(part1(input))
//    println(part2(input))
}


