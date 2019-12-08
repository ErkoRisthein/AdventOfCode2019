package ee.risthein.erko.adventofcode2019

class Day1 {

    fun getFuelRequired(mass: Int): Int {
        return mass / 3 - 2
    }

    fun getTotalFuelRequired(masses: List<Int>): Int {
        return masses.fold(0) { sum, mass -> sum + getFuelRequired(mass) }
    }

}
