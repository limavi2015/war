package stratio.domain.services

import stratio.ServiceError
import stratio.domain.{Coordinate, CoordinateWrong, DecryptedCoordinate}

class DecryptService {

  def decrypCoordinates(coordinates: List[Coordinate])
    : Either[ServiceError, List[DecryptedCoordinate]] = {
    val coordinatesValidated = coordinates.map(Coordinate.validate)
    if (coordinatesValidated.exists(_.isLeft))
      Left(CoordinateWrong(messageError(coordinatesValidated)))
    else
      Right(coordinates.map(decryp))
  }

  private def decryp(co: Coordinate): DecryptedCoordinate =
    DecryptedCoordinate(
      galaxy = decryptGalaxy(co.galaxy),
      quadrant = decrypQuadrant(co.quadrant),
      star = decrypStar(co.starSystem, co.starSecondSystem),
      planet = decrypPlanet(co.planet)
    )

  private def decryptGalaxy(galaxy: String): String =
    galaxy.toList
      .map(charHex => Integer.parseInt(charHex.toString, 16))
      .sum
      .toString

  private def decrypPlanet(planet: String): String =
    planet.toList.distinct.sorted.reverse.mkString("")

  private def decrypQuadrant(quadrant: String): String =
    Integer.parseInt(quadrant.toList.max.toString, 16).toString

  private def decrypStar(starsystem1: String, starsystem2: String): String = {
    starsystem1.toList.zipWithIndex
      .map {
        case (elementStar1, index) =>
          if (elementStar1 > starsystem2.charAt(index)) elementStar1
          else starsystem2.charAt(index)
      }
      .map(charHex => Integer.parseInt(charHex.toString, 16))
      .sum
      .toString
  }

  private def messageError(
      resultValidations: Seq[Either[Seq[stratio.ServiceError], Coordinate]])
    : String = {
    val result = resultValidations.map(
      _.fold(e => s"Error -> ${e.map(_.message)}", c => s"Decrypted -> $c"))
    s"The input coordinates have wrong values: $result"
  }
}
