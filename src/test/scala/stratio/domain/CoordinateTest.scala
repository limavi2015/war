package stratio.domain

import stratio.TestSpec

class CoordinateTest extends TestSpec {

  "Coordinate object" should " validate a correct coordinate" in {
    val coordinateCorrect= Coordinate("6f9c15fa","ef51","4415","afab","36218d76c2d9")
    Coordinate.validate(coordinateCorrect) shouldBe Right(coordinateCorrect)
  }

  "it" should " generate an error with a coordinate that has a wrong galaxy" in {
    val coordinateCorrect= Coordinate("6f9c15faxx","ef51","4415","afab","36218d76c2d9")
    Coordinate.validate(coordinateCorrect) shouldBe Left(List(CoordinateWrong("The galaxy field should has 8 digits")))
  }

  "it" should " generate an error with a coordinate that has a wrong quadrant" in {
    val coordinateCorrect= Coordinate("6f9c15fa","ef51xx","4415","afab","36218d76c2d9")
    Coordinate.validate(coordinateCorrect) shouldBe Left(List(CoordinateWrong("The quadrant field should has 4 digits")))
  }

  "it" should " generate an error with a coordinate that has a wrong starsystem" in {
    val coordinateCorrect= Coordinate("6f9c15fa","ef51","4415xx","afab","36218d76c2d9")
    Coordinate.validate(coordinateCorrect) shouldBe Left(List(CoordinateWrong("The starSystem field should has 4 digits")))
  }

  "it" should " generate an error with a coordinate that has a wrong starSecondSystem " in {
    val coordinateCorrect= Coordinate("6f9c15fa","ef51","4415","afabxx","36218d76c2d9")
    Coordinate.validate(coordinateCorrect) shouldBe Left(List(CoordinateWrong("The starSecondSystem field should has 4 digits")))
  }

  "it" should " generate an error with a coordinate that has a wrong planet" in {
    val coordinateCorrect= Coordinate("6f9c15fa","ef51","4415","afab","36218d76c2d9xx")
    Coordinate.validate(coordinateCorrect) shouldBe Left(List(CoordinateWrong("The planet field should has 12 digits")))
  }
}
