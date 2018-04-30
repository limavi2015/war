package stratio

import akka.actor.ActorSystem
import akka.http.scaladsl.Http
import akka.stream.ActorMaterializer
import akka.util.Timeout
import com.typesafe.config.ConfigFactory

import scala.concurrent.duration._

object Main extends App with RestInterface {

  val config = ConfigFactory.load()
  val configHost = config.getString("http.host")
  val configPort = config.getInt("http.port")

  implicit val system = ActorSystem("startio")
  implicit val materializer = ActorMaterializer()

  implicit val executionContext = system.dispatcher
  implicit val timeout = Timeout(10.seconds)

  val api = routes

  Http().bindAndHandle(handler = api, interface = configHost, port = configPort) map {
    binding =>
      println(
        s"Http service started - Listening for HTTP on ${binding.localAddress}")
  } recover {
    case ex =>
  }
}
