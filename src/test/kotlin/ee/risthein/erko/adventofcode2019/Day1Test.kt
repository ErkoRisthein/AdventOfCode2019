package ee.risthein.erko.adventofcode2019

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.CsvSource
import java.io.File

class Day1Test {

    private val day1 = Day1()

    @ParameterizedTest
    @CsvSource("12, 2", "14, 2", "1969, 654", "100756, 33583")
    fun `can calculate required fuel from mass`(mass: Int, fuel: Int) {
        val fuelRequired = day1.getFuelRequired(mass)

        assertThat(fuelRequired).isEqualTo(fuel)
    }

    @Test
    fun `can calculate the total fuel required`() {
        val masses = File(javaClass.getResource("/day1input.txt").toURI()).readLines().map { it.toInt() }

        val totalFuelRequired = day1.getTotalFuelRequired(masses)

        assertThat(totalFuelRequired).isEqualTo(3358992)
    }

    @ParameterizedTest
    @CsvSource("14, 2", "1969, 966", "100756, 50346")
    fun `can calculate the absolute fuel required`(mass: Int, fuel: Int) {
        val fuelRequired = day1.getAbsoluteFuelRequired(mass)

        assertThat(fuelRequired).isEqualTo(fuel)
    }

    @Test
    fun `can calculate the absolute fuel required`() {
        val masses = File(javaClass.getResource("/day1input.txt").toURI()).readLines().map { it.toInt() }

        val absoluteFuelRequired = day1.getAbsoluteFuelRequired(masses)

        assertThat(absoluteFuelRequired).isEqualTo(5035632)
    }
}