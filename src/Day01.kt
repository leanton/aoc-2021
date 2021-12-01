import java.lang.Integer.sum

fun main() {
    val input = readInput("data/Day01")
    val intInput = input.map { it.toInt() }
    val count = intInput.zipWithNext().count { it.first < it.second }
    println(count)

    val sumThree = intInput.zip(intInput.drop(1), ::sum).zip(intInput.drop(2), ::sum)
    val countSum3 = sumThree.zipWithNext().count { it.first < it.second }
    println(countSum3)
}
