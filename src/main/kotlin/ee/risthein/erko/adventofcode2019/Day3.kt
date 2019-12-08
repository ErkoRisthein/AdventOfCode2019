package ee.risthein.erko.adventofcode2019

import ee.risthein.erko.adventofcode2019.Day3.Wire.INTERSECTION
import ee.risthein.erko.adventofcode2019.Day3.Wire.WIRE
import kotlin.math.abs

class Day3 {

    fun getDistance(wire1: String, wire2: String): Int {
        val steps1 = wire1.split(",").map(toStep())
        val steps2 = wire2.split(",").map(toStep())
        val points = mutableMapOf<Point, Wire>()
        val startingPoint = Point(0, 0)

        var currentPoint = startingPoint
        for (step in steps1) {
            for (i in 1..step.amount) {
                currentPoint += step.direction.diff()
                points[currentPoint] = WIRE
            }
        }

        currentPoint = startingPoint
        for (step in steps2) {
            for (i in 1..step.amount) {
                currentPoint += step.direction.diff()
                if (points.containsKey(currentPoint)) {
                    points[currentPoint] = INTERSECTION
                } else {
                    points[currentPoint] = WIRE
                }
            }
        }

        return getShortestDistance(points)
    }

    private fun getShortestDistance(map: Map<Point, Wire>): Int {
        var shortestDistance = Integer.MAX_VALUE
        for ((point, wire) in map) {
            if (wire == INTERSECTION) {
                val distance = abs(point.x) + abs(point.y)
                if (distance < shortestDistance) {
                    shortestDistance = distance
                }
            }
        }
        return shortestDistance
    }

    enum class Wire {
        WIRE, INTERSECTION
    }

    private fun toStep(): (String) -> Step = {
        Step(Direction.from(it.first()), it.drop(1).toInt())
    }

    data class Step(val direction: Direction, val amount: Int)

    enum class Direction {
        UP {
            override fun diff() = Point(-1, 0)
        },
        DOWN {
            override fun diff() = Point(1, 0)
        },
        LEFT {
            override fun diff() = Point(0, -1)
        },
        RIGHT {
            override fun diff() = Point(0, 1)
        };

        abstract fun diff(): Point

        companion object {
            fun from(abbreviation: Char): Direction {
                return when (abbreviation) {
                    'U' -> UP
                    'D' -> DOWN
                    'L' -> LEFT
                    'R' -> RIGHT
                    else -> throw error("Unknown direction $abbreviation")
                }
            }

        }
    }

    data class Point(val x: Int, val y: Int) {
        operator fun plus(point: Point) = Point(x + point.x, y + point.y)
    }

}
