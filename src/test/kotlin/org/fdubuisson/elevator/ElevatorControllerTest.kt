package org.fdubuisson.elevator

import org.fdubuisson.elevator.Command.UP
import kotlin.test.Test
import kotlin.test.assertEquals

class ElevatorControllerTest {

    @Test
    fun `should go up to user call`() {
        val controller = ElevatorController(startFloor = 0, doorsOpenedAtStart = false)

        controller.onUserCall(1, Direction.UP)

        controller.assertNextCommandsAre(
            UP,
        )
    }

    /*
        @Test
        fun `should go down to user call`() {
            val controller = ElevatorController(startFloor = 3, doorsOpenedAtStart = false)

            controller.onUserCall(1, Direction.UP)

            controller.assertNextCommandsAre(
                DOWN,
                DOWN,
            )
        }

        @Test
        fun `should open doors if users need to enter`() {
            val controller = ElevatorController(startFloor = 0, doorsOpenedAtStart = false)

            controller.onUserCall(0, Direction.UP)

            controller.assertNextCommandsAre(
                OPEN,
                NOTHING,
            )
        }

        @Test
        fun `should close doors if open, before moving`() {
            val controller = ElevatorController(startFloor = 0, doorsOpenedAtStart = true)

            controller.onUserCall(1, Direction.UP)

            controller.assertNextCommandsAre(
                CLOSE,
                UP,
                OPEN,
                NOTHING,
            )
        }

        @Test
        fun `should bring user to requested floor and open doors`() {
            val controller = ElevatorController(startFloor = 0, doorsOpenedAtStart = true)

            controller.onUserCall(0, Direction.UP)
            controller.onUserDestinationChoice(2)

            controller.assertNextCommandsAre(
                CLOSE,
                UP,
                UP,
                OPEN,
                NOTHING,
            )
        }

        @Test
        fun `should support consecutive requests`() {
            val controller = ElevatorController(startFloor = 0, doorsOpenedAtStart = true)

            controller.onUserCall(0, Direction.UP)
            controller.onUserDestinationChoice(1)

            controller.onUserCall(2, Direction.DOWN)
            controller.onUserDestinationChoice(1)

            controller.assertNextCommandsAre(
                CLOSE,
                UP,
                OPEN,
                CLOSE,
                UP,
                OPEN,
                CLOSE,
                DOWN,
                OPEN,
                NOTHING,
            )
        }

        @Test
        fun `should support different requests from same floor users`() {
            val controller = ElevatorController(startFloor = 0, doorsOpenedAtStart = true)

            controller.onUserCall(0, Direction.UP)
            controller.onUserCall(0, Direction.UP)
            controller.onUserDestinationChoice(1)
            controller.onUserDestinationChoice(2)

            controller.assertNextCommandsAre(
                CLOSE,
                UP,
                OPEN,
                CLOSE,
                UP,
                OPEN,
                NOTHING,
            )
        }

        @Test
        fun `should support mixed requests`() {
            val controller = ElevatorController(startFloor = 0, doorsOpenedAtStart = true)

            controller.onUserCall(0, Direction.UP)
            controller.onUserCall(1, Direction.UP)
            controller.onUserDestinationChoice(3)
            controller.onUserDestinationChoice(2)

            controller.assertNextCommandsAre(
                CLOSE,
                UP,
                OPEN,
                CLOSE,
                UP,
                OPEN,
                CLOSE,
                UP,
                OPEN,
                NOTHING,
            )
        }

        @Test
        fun `should open doors only once per floor for entering and exising users`() {
            val controller = ElevatorController(startFloor = 0, doorsOpenedAtStart = true)

            controller.onUserCall(0, Direction.UP)
            controller.onUserCall(1, Direction.UP)
            controller.onUserDestinationChoice(1)
            controller.onUserDestinationChoice(2)

            controller.assertNextCommandsAre(
                CLOSE,
                UP,
                OPEN,
                CLOSE,
                UP,
                OPEN,
                NOTHING,
            )
        }

        @Test
        fun `should respect elevator max capacity of 3 users`() {
            val controller = ElevatorController(startFloor = 0, doorsOpenedAtStart = true)

            controller.onUserCall(0, Direction.UP)
            controller.onUserCall(0, Direction.UP)
            controller.onUserCall(0, Direction.UP)
            controller.onUserDestinationChoice(1)
            controller.onUserDestinationChoice(1)
            controller.onUserDestinationChoice(1)
            controller.onUserCall(0, Direction.UP)
            controller.onUserDestinationChoice(1)

            controller.assertNextCommandsAre(
                CLOSE,
                UP,
                OPEN,
                CLOSE,
                DOWN,
                OPEN,
                CLOSE,
                UP,
                OPEN,
                NOTHING,
            )
        }
    */
    private fun ElevatorController.assertNextCommandsAre(vararg commands: Command) =
        commands.toList()
            .map { it to nextCommand() }
            .let { pairs -> assertEquals(pairs.map { it.first }, pairs.map { it.second }) }
}