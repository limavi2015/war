package stratio.infrastructure.http.api

import akka.http.scaladsl.marshalling.{
  ToResponseMarshallable,
  ToResponseMarshaller
}
import akka.http.scaladsl.server.{Directives, Route}
import stratio.ServiceError
import stratio.domain.DecryptedCoordinate
import stratio.infrastructure.http.serializer.JsonSupport

import scala.concurrent.{ExecutionContext, Future}

trait MyResource extends Directives with JsonSupport {

  implicit def executionContext: ExecutionContext

  def handleResponse[T: ToResponseMarshaller](resource: Future[T]): Route =
    onSuccess(resource) {
      case t: List[DecryptedCoordinate] => complete(ToResponseMarshallable(t))
      case error: ServiceError          => complete(400, error)
      case _                            => complete(501, None)
    }
}
