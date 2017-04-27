package toyrobot

import org.scalatest.{ FunSpec, Matchers }
import org.scalatest.prop.GeneratorDrivenPropertyChecks
import org.scalacheck.Gen

import Surface._

class SurfaceSpec extends FunSpec with Matchers with GeneratorDrivenPropertyChecks {
  // default minSuccessful of 10 is too low
  implicit override val generatorDrivenConfig = PropertyCheckConfiguration(minSuccessful = 100)

  describe("table") {
    val validCoord = Gen.choose(0, 4)
    val invalidCoord = Gen.oneOf(Gen.negNum[Int], Gen.posNum[Int] suchThat (_ > 4))

    it("should be true when (x, y) are both between 0 to 4 (both inclusive)") {
      forAll (validCoord, validCoord) { (x: Int, y: Int) => table(x, y) shouldBe true }
    }

    it("should be false when at least one of (x, y) are not between 0 to 4 (both inclusive)") {
      forAll (invalidCoord, validCoord) { (x: Int, y: Int) => table(x, y) shouldBe false }
      forAll (validCoord, invalidCoord) { (x: Int, y: Int) => table(x, y) shouldBe false }
      forAll (invalidCoord, invalidCoord) { (x: Int, y: Int) => table(x, y) shouldBe false }
    }
  }
}
