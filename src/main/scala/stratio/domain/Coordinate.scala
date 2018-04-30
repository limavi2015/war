package stratio.domain

import stratio.ServiceError

case class Coordinate(
    galaxy: String,
    quadrant: String,
    starSystem: String,
    starSecondSystem: String,
    planet: String
)

object Coordinate {

  def validate(
      coordinate: Coordinate): Either[Seq[ServiceError], Coordinate] = {
    val validations = List(
      validateDigits("galaxy", coordinate.galaxy, 8),
      validateDigits("quadrant", coordinate.quadrant, 4),
      validateDigits("starSystem", coordinate.starSystem, 4),
      validateDigits("starSecondSystem", coordinate.starSecondSystem, 4),
      validateDigits("planet", coordinate.planet, 12)
    )
    if (validations.exists(_.isLeft)) Left(splitEitherList(validations)._1)
    else Right(coordinate)
  }

  private[domain] def validateDigits(
      field: String,
      fieldValue: String,
      digits: Int): Either[ServiceError, String] =
    if (fieldValue.length != digits)
      Left(CoordinateWrong(s"The $field field should has $digits digits"))
    else Right(fieldValue)

  private def splitEitherList[A, B](el: List[Either[A, B]]) = {
    val (lefts, rights) = el.partition(_.isLeft)
    (lefts.map(_.left.get), rights.map(_.right.get))
  }
}

case class CoordinateWrong(message: String) extends ServiceError
