import com.typesafe.config.{Config, ConfigFactory}
import org.scalatest.flatspec.AnyFlatSpec
import org.scalatest.matchers.should.Matchers

class SomeTestISpec extends AnyFlatSpec with Matchers {

  "SomeTestISpec (integration test)" should "do something" in {
    // print data from configuration file
    val config: Config = ConfigFactory.load()
    val value          = config.getString("some-value")
    println(s"SomeTestISpec, some-value = $value")
  }
}
