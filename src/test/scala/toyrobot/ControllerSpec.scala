package toyrobot

import org.scalatest.{ FunSpec, Matchers }

import Controller._

class ControllerSpec extends FunSpec with Matchers {
  describe("place") {
    it("should create a robot at 0, 0 facing North if x = 0, y = 0, direction = North") {
      place(0, 0, North) shouldBe Robot(0, 0, North)
    }

    it("should create a robot at 1, 1 facing East if x = 1, y = 1, direction = East") {
      place(1, 1, East) shouldBe Robot(1, 1, East)
    }

    it("should create a robot at 2, 2 facing South if x = 2, y = 2, direction = South") {
      place(2, 2, South) shouldBe Robot(2, 2, South)
    }

    it("should create a robot at 3, 3 facing West if x = 3, y = 3, direction = West") {
      place(3, 3, West) shouldBe Robot(3, 3, West)
    }
  }

  describe("move") {
    it("should move a robot facing North up one unit") {
      move(Robot(2, 2, North)) shouldBe Robot(2, 3, North)
    }

    it("should move a robot facing East right one unit") {
      move(Robot(2, 2, East)) shouldBe Robot(3, 2, East)
    }

    it("should move a robot facing South down one unit") {
      move(Robot(2, 2, South)) shouldBe Robot(2, 1, South)
    }

    it("should move a robot facing West left one unit") {
      move(Robot(2, 2, West)) shouldBe Robot(1, 2, West)
    }
  }

  describe("left") {
    it("should turn a robot facing North to the West, without changing position") {
      left(Robot(0, 0, North)) shouldBe Robot(0, 0, West)
    }

    it("should turn a robot facing East to the North, without changing position") {
      left(Robot(1, 1, East)) shouldBe Robot(1, 1, North)
    }

    it("should turn a robot facing South to the East, without changing position") {
      left(Robot(2, 2, South)) shouldBe Robot(2, 2, East)
    }

    it("should turn a robot facing West to the South, without changing position") {
      left(Robot(3, 3, West)) shouldBe Robot(3, 3, South)
    }
  }

  describe("right") {
    it("should turn a robot North to the East, without changing position") {
      right(Robot(0, 0, North)) shouldBe Robot(0, 0, East)
    }

    it("should turn a robot facing East to the South, without changing position") {
      right(Robot(1, 1, East)) shouldBe Robot(1, 1, South)
    }

    it("should turn a robot facing South to the West, without changing position") {
      right(Robot(2, 2, South)) shouldBe Robot(2, 2, West)
    }

    it("should turn a robot facing West to the North, without changing position") {
      right(Robot(3, 3, West)) shouldBe Robot(3, 3, North)
    }
  }

  describe("report") {
    it("should return 3,3,NORTH for a robot at 3, 3 facing North") {
      report(Robot(3, 3, North)) shouldBe "3,3,NORTH"
    }

    it("should return 2,2,EAST for a robot at 2, 2 facing East") {
      report(Robot(2, 2, East)) shouldBe "2,2,EAST"
    }

    it("should return 1,1,SOUTH for a robot at 1, 1 facing South") {
      report(Robot(1, 1, South)) shouldBe "1,1,SOUTH"
    }

    it("should return 0,0,WEST for a robot at 0, 0 facing West") {
      report(Robot(0, 0, West)) shouldBe "0,0,WEST"
    }
  }
}
