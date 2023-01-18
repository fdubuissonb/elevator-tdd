package org.fdubuisson.elevator

class ElevatorController(
    startFloor: Int,
    doorsOpenedAtStart: Boolean
) {
    fun onUserCall(atFloor: Int, direction: Direction) {
        TODO("Not yet implemented")
    }

    fun onUserDestinationChoice(floor: Int) {
        TODO("Not yet implemented")
    }

    fun nextCommand(): Command {
        TODO("Not yet implemented")
    }
}

enum class Direction {
    UP,
    DOWN
}

enum class Command {
    NOTHING,
    UP,
    DOWN,
    OPEN,
    CLOSE
}
