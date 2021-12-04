import kotlin.math.abs

fun main() {
    data class Command(val x: Int, val y: Int) {
        init {
            check(x != 0 || y != 0)
        }

        operator fun plus(that: Command): Command = Command(this.x + that.x, this.y + that.y)
    }

    fun mapToCommand(cmd: String): Command {
        val split = cmd.split(" ")
        val step = split[1].toInt()
        return when (split[0]) {
            "forward" -> Command(step, 0)
            "up" -> Command(0, -step)
            "down" -> Command(0, step)
            else -> throw IllegalStateException("Unable to parse")
        }
    }

    fun part1(input: List<String>): Int {
        val (x, y) = input.map(::mapToCommand).reduce { a, b -> a + b }
        return x * abs(y)
    }


    fun part2(input: List<String>): Int {
        data class State(
            val horizontalPosition: Int,
            val depth: Int,
            val aim: Int
        ) {
            fun apply(cmd: Command): State {
                return if (cmd.x != 0) {
                    this.copy(
                        horizontalPosition = this.horizontalPosition + cmd.x,
                        depth = this.depth + this.aim * cmd.x
                    )
                } else {
                    this.copy(
                        aim = this.aim + cmd.y
                    )
                }
            }
        }

        val finalState = input.map(::mapToCommand).fold(State(0, 0, 0), State::apply)
        return finalState.horizontalPosition * abs(finalState.depth)
    }

    // test if implementation meets criteria from the description, like:
    val testInput = readInput("Day02_test")
    check(part1(testInput) == 150)
    check(part2(testInput) == 900)

    val input = readInput("Day02")
    println(part1(input))
    println(part2(input))
}


