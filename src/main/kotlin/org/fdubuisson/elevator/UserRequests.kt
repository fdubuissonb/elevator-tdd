package org.fdubuisson.elevator

class UserRequests {
  private val userRequests = mutableListOf<Int>()

  fun addRequest(atFloor: Int) = userRequests.add(atFloor)

  fun nextRequest() = userRequests.first()

  fun removeRequestsAt(floor: Int) = userRequests.removeAll { it == floor }

  fun isEmpty() = userRequests.isEmpty()
}