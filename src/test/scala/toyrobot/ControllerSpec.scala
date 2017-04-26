package toyrobot

import org.scalatest.{ FunSpec, Matchers }

import Controller._

class ControllerSpec extends FunSpec with Matchers {
  describe("place") {
    it("should create a robot with the specified coordinates, facing the specified direction") {
      place(0, 0, North) shouldBe Robot(0, 0, North)
      place(1, 1, East) shouldBe Robot(1, 1, East)
      place(2, 2, South) shouldBe Robot(2, 2, South)
      place(3, 3, West) shouldBe Robot(3, 3, West)
    }
  }

  describe("move") {
    it("should move a robot facing NORTH up one unit") {
      move(Robot(2, 2, North)) shouldBe Robot(2, 3, North)
    }

    it("should move a robot facing EAST right one unit") {
      move(Robot(2, 2, East)) shouldBe Robot(3, 2, East)
    }

    it("should move a robot facing SOUTH down one unit") {
      move(Robot(2, 2, South)) shouldBe Robot(2, 1, South)
    }

    it("should move a robot facing WEST left one unit") {
      move(Robot(2, 2, West)) shouldBe Robot(1, 2, West)
    }
  }
}
