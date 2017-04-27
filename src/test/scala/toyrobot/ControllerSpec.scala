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

  describe("left") {
    it("should turn a robot facing NORTH to the WEST, without changing position") {
      left(Robot(0, 0, North)) shouldBe Robot(0, 0, West)
    }

    it("should turn a robot facing EAST to the NORTH, without changing position") {
      left(Robot(1, 1, East)) shouldBe Robot(1, 1, North)
    }

    it("should turn a robot facing SOUTH to the EAST, without changing position") {
      left(Robot(2, 2, South)) shouldBe Robot(2, 2, East)
    }

    it("should turn a robot facing WEST to the SOUTH, without changing position") {
      left(Robot(3, 3, West)) shouldBe Robot(3, 3, South)
    }
  }

  describe("right") {
    it("should turn a robot NORTH to the EAST, without changing position") {
      right(Robot(0, 0, North)) shouldBe Robot(0, 0, East)
    }

    it("should turn a robot facing EAST to the SOUTH, without changing position") {
      right(Robot(1, 1, East)) shouldBe Robot(1, 1, South)
    }

    it("should turn a robot facing SOUTH to the WEST, without changing position") {
      right(Robot(2, 2, South)) shouldBe Robot(2, 2, West)
    }

    it("should turn a robot facing WEST to the NORTH, without changing position") {
      right(Robot(3, 3, West)) shouldBe Robot(3, 3, North)
    }
  }
}
