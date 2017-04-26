package toyrobot

import org.scalatest.FunSuite

import Controller._

class ControllerSuite extends FunSuite {
  test("place should create a robot with the specified coordinates, facing the specified direction") {
    assertResult(Robot(0, 0, North)) {
      place(0, 0, North)
    }

    assertResult(Robot(1, 1, East)) {
      place(1, 1, East)
    }

    assertResult(Robot(2, 2, South)) {
      place(2, 2, South)
    }

    assertResult(Robot(3, 3, West)) {
      place(3, 3, West)
    }
  }

  test("robot facing NORTH should move up one unit") {
    assertResult(Robot(2, 3, North)) {
      move(Robot(2, 2, North))
    }
  }

  test("robot facing EAST should move right one unit") {
    assertResult(Robot(3, 2, East)) {
      move(Robot(2, 2, East))
    }
  }

  test("robot facing SOUTH should move down one unit") {
    assertResult(Robot(2, 1, South)) {
      move(Robot(2, 2, South))
    }
  }

  test("robot facing WEST should move left one unit") {
    assertResult(Robot(1, 2, West)) {
      move(Robot(2, 2, West))
    }
  }
}
