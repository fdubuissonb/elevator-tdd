package org.fdubuisson.elevator

class ElevatorController(
  startFloor: Int,
  doorsOpenedAtStart: Boolean
) {
  private val userRequests = UserRequests()
  private val elevator = Elevator(startFloor, doorsOpenedAtStart)

  fun onUserCall(atFloor: Int, direction: Direction) {
    if (!elevator.isAtFloor(atFloor) || elevator.areDoorsClosed()) {
      userRequests.addRequest(atFloor)
    }
  }

  fun onUserDestinationChoice(floor: Int) {
    userRequests.addRequest(floor)
  }

  fun nextCommand(): Command = when {
    userRequests.isEmpty() -> Command.NOTHING

    userRequests.removeRequestsAt(elevator.currentFloor()) -> {
      elevator.openDoors()
      Command.OPEN
    }

    elevator.areDoorsOpen() -> {
      elevator.closeDoors()
      Command.CLOSE
    }

    userRequests.nextRequest() < elevator.currentFloor() -> {
      elevator.moveDown()
      Command.DOWN
    }

    else -> {
      elevator.moveUp()
      Command.UP
    }
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
