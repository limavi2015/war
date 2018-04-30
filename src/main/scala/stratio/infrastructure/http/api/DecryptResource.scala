package stratio.infrastructure.http.api

import akka.http.scaladsl.server.Route
import stratio.domain.Coordinate
import stratio.domain.services.DecryptService

import scala.concurrent.Future

trait DecryptResource extends MyResource {

  val decryptService = new DecryptService()

  def decryptRoutes: Route = pathPrefix("decrypt") {
    pathEnd {
      post {
        entity(as[List[Coordinate]]) { coordinates =>
          decryptService
            .decrypCoordinates(coordinates)
            .fold(
              errors => handleResponse(Future.successful(errors)),
              coordinates => handleResponse(Future.successful(coordinates))
            )
        }
      }
    }
  }

}
