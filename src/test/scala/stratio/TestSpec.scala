package stratio

import org.scalatest._
import org.scalatest.concurrent.{IntegrationPatience, ScalaFutures}

trait TestSpec
    extends FlatSpec with Matchers with Inspectors with ScalaFutures with OptionValues with BeforeAndAfterAll
    with IntegrationPatience with GivenWhenThen
