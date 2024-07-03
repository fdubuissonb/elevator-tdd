package org.fdubuisson.elevator

class Elevator(
  private val startFloor: Int,
  doorsOpenedAtStart: Boolean,
) {
  private var currentFloor = startFloor
  private val doors = Doors(doorsOpenedAtStart)

  fun moveUp() {
    currentFloor++
  }

  fun moveDown() {
    currentFloor--
  }

  fun openDoors() {
    doors.open()
  }

  fun closeDoors() {
    doors.close()
  }

  fun currentFloor() = currentFloor
  fun isAtFloor(floor: Int) = currentFloor == floor

  fun areDoorsOpen() = doors.areOpen()
  fun areDoorsClosed() = doors.areClosed()
}
