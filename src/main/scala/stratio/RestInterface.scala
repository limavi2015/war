package stratio

import akka.http.scaladsl.server.Route
import stratio.infrastructure.http.api.DecryptResource

import scala.concurrent.ExecutionContext

trait RestInterface extends Resources {

  implicit def executionContext: ExecutionContext

  val routes: Route = decryptRoutes
}

trait Resources extends DecryptResource
