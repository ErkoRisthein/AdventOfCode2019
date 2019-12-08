package ee.risthein.erko.adventofcode2019

const val HALT = 99
const val ADD = 1
const val MULTIPLY = 2

class Day2 {

    fun run(input: List<Int>): List<Int> {
        val integers = input.toMutableList()

        for (i in integers.indices step 4) {
            val operator = integers[i]
            if (operator == HALT) {
                break
            }
            val input1Position = integers[i + 1]
            val input2Position = integers[i + 2]
            val outputPosition = integers[i + 3]

            val input1 = integers[input1Position]
            val input2 = integers[input2Position]

            when (operator) {
                ADD -> integers[outputPosition] = input1 + input2
                MULTIPLY -> integers[outputPosition] = input1 * input2
                else -> throw error("Unknown operator: $operator")
            }
        }
        return integers
    }

}
