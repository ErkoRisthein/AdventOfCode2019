package ee.risthein.erko.adventofcode2019

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import java.io.File

class Day3Test {

    private val day3 = Day3()


    @Test
    fun `works with 1st sample`() {
        val distance = day3.getDistance(
            "R8,U5,L5,D3",
            "U7,R6,D4,L4"
        )

        assertThat(distance).isEqualTo(6)
    }

    @Test
    fun `works with 2nd sample`() {
        val distance = day3.getDistance(
            "R75,D30,R83,U83,L12,D49,R71,U7,L72",
            "U62,R66,U55,R34,D71,R55,D58,R83"
        )

        assertThat(distance).isEqualTo(159)
    }

    @Test
    fun `works with 3rd sample`() {
        val distance = day3.getDistance(
            "R98,U47,R26,D63,R33,U87,L62,D20,R33,U53,R51",
            "U98,R91,D20,R16,D67,R40,U7,R15,U6,R7"
        )

        assertThat(distance).isEqualTo(135)
    }

    @Test
    fun `can solve puzzle`() {
        val wires = File(javaClass.getResource("/day3input.txt").toURI()).readLines()

        val distance = day3.getDistance(wires[0], wires[1])

        assertThat(distance).isEqualTo(1626)
    }
}