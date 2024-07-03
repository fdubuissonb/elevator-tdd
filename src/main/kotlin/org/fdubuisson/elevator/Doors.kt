package org.fdubuisson.elevator

class Doors(
  private var opened: Boolean
) {
  fun open() {
    opened = true
  }

  fun close() {
    opened = false
  }

  fun areOpen() = opened
  fun areClosed() = !opened
}
