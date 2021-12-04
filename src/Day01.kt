fun main() {
    fun part1(input: List<String>): Int {
        val intInput = input.map { it.toInt() }
        return intInput.zipWithNext().count { it.first < it.second }
    }

    fun part2(input: List<String>): Int {
        val intInput: List<Int> = input.map { it.toInt() }
        val sumThree = intInput.windowed(size = 3, transform = { it.sum() })
        return sumThree.zipWithNext().count { it.first < it.second }
    }

    // test if implementation meets criteria from the description, like:
    val testInput = readInput("Day01_test")
    check(part1(testInput) == 7)
    check(part2(testInput) == 5)

    val input = readInput("Day01")
    println(part1(input))
    println(part2(input))
}
