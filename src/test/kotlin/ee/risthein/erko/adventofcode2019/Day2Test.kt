package ee.risthein.erko.adventofcode2019

import ee.risthein.erko.adventofcode2019.Day2.Inputs
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.TestInstance
import org.junit.jupiter.api.TestInstance.Lifecycle
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.Arguments.arguments
import org.junit.jupiter.params.provider.MethodSource
import java.io.File
import java.util.stream.Stream


@TestInstance(Lifecycle.PER_CLASS)
class Day2Test {

    private val day2 = Day2()

    @Test
    fun `works with the first example`() {
        val input = listOf(
            1, 9, 10, 3,
            2, 3, 11, 0,
            99,
            30, 40, 50
        )

        val output = day2.run(input)

        assertThat(output).isEqualTo(
            listOf(
                3500, 9, 10, 70,
                2, 3, 11, 0,
                99,
                30, 40, 50
            )
        )
    }

    @ParameterizedTest
    @MethodSource("inputAndOutputProvider")
    fun `works with the rest of the examples`(
        input: List<Int>,
        expectedOutput: List<Int>
    ) {
        val output = day2.run(input)

        assertThat(output).isEqualTo(expectedOutput)
    }

    fun inputAndOutputProvider(): Stream<Arguments> {
        return Stream.of(
            arguments(listOf(1, 0, 0, 0, 99), listOf(2, 0, 0, 0, 99)),
            arguments(listOf(2, 3, 0, 3, 99), listOf(2, 3, 0, 6, 99)),
            arguments(listOf(2, 4, 4, 5, 99, 0), listOf(2, 4, 4, 5, 99, 9801)),
            arguments(listOf(1, 1, 1, 4, 99, 5, 6, 0, 99), listOf(30, 1, 1, 4, 2, 5, 6, 0, 99))
        )
    }

    @Test
    fun `can calculate puzzle output`() {
        val initialState = File(javaClass.getResource("/day2input.txt").toURI()).readText().split(",").map { it.toInt() }
        val inputs = Inputs(12, 2)

        val output = day2.getOutput(initialState, inputs)

        assertThat(output).isEqualTo(3562624)
    }

    @Test
    fun `can find inputs for given output`() {
        val initialState = File(javaClass.getResource("/day2input.txt").toURI()).readText().split(",").map { it.toInt() }
        val output = 19690720

        val inputs = day2.getInputs(initialState, output)

        assertThat(inputs.noun).isEqualTo(82)
        assertThat(inputs.verb).isEqualTo(98)
    }

    @Test
    fun `can find puzzle solution`() {
        val initialState = File(javaClass.getResource("/day2input.txt").toURI()).readText().split(",").map { it.toInt() }
        val output = 19690720

        val solution = day2.getPuzzleSolution(initialState, output)

        assertThat(solution).isEqualTo(8298)
    }
}