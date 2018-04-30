package stratio.domain.services

import stratio.TestSpec
import stratio.domain.{Coordinate, CoordinateWrong, DecryptedCoordinate}

class DecryptServiceTest extends TestSpec {

  val service = new DecryptService

  "DecryptService" should " decrypt a list of correct coordinates" in {
    val coordinateCorrect1= Coordinate("2952410b","0a94","446b","8bcb","448dc6e30b08")
    val coordinateCorrect2= Coordinate("6f9c15fa","ef51","4415","afab","36218d76c2d9")
    val coordinateCorrect3= Coordinate("2ab81c9b","1719","400c","a676","bdba976150eb")

    val decryptCoordinate1=DecryptedCoordinate("34","10","42","edcb86430")
    val decryptCoordinate2=DecryptedCoordinate("73","15","46","dc9876321")
    val decryptCoordinate3=DecryptedCoordinate("64","9", "35","edba976510")

    service.decrypCoordinates(List(coordinateCorrect1,coordinateCorrect2,coordinateCorrect3)) shouldBe Right(List(
      decryptCoordinate1,decryptCoordinate2,decryptCoordinate3
    ))
  }

  "DecryptService" should " generate a error with a list that has a incorrect coordinate" in {
    val coordinateCorrect1= Coordinate("2952410b","0a94","446b","8bcb","448dc6e30b08")
    val coordinateCorrect2= Coordinate("6f9c15fa","ef51","4415","afab","36218d76c2d9")
    val coordinateCorrect3= Coordinate("xx","1719","400c","a676","bdba976150eb")

    service.decrypCoordinates(List(coordinateCorrect1,coordinateCorrect2,coordinateCorrect3)) shouldBe
      Left(CoordinateWrong("The input coordinates have wrong values: List(" +
        "Decrypted -> Coordinate(2952410b,0a94,446b,8bcb,448dc6e30b08), " +
        "Decrypted -> Coordinate(6f9c15fa,ef51,4415,afab,36218d76c2d9), " +
        "Error -> List(The galaxy field should has 8 digits))"))
  }


}
