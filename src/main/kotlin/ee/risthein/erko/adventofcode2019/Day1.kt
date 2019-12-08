package ee.risthein.erko.adventofcode2019

import kotlin.math.max

class Day1 {

    fun getFuelRequired(mass: Int): Int {
        return max(mass / 3 - 2, 0)
    }

    fun getTotalFuelRequired(masses: List<Int>): Int {
        return masses.fold(0) { sum, mass -> sum + getFuelRequired(mass) }
    }

    fun getAbsoluteFuelRequired(masses: List<Int>): Int {
        return masses.fold(0) { sum, mass -> sum + getAbsoluteFuelRequired(mass) }
    }

    fun getAbsoluteFuelRequired(fuel: Int): Int {
        return getAbsoluteFuelRequired(0, fuel)
    }

    private tailrec fun getAbsoluteFuelRequired(total: Int, fuel: Int): Int {
        if (fuel <= 0) return total
        val extraFuel = getFuelRequired(fuel)
        return getAbsoluteFuelRequired(total + extraFuel, extraFuel)
    }
}
