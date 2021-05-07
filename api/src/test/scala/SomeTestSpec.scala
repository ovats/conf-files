import com.typesafe.config.{Config, ConfigFactory}
import org.scalatest.flatspec.AnyFlatSpec
import org.scalatest.matchers.should.Matchers

class SomeTestSpec extends AnyFlatSpec with Matchers {

  "SomeTest (unit test)" should "use test.conf" in {
    // print data from configuration file
    val config: Config = ConfigFactory.load()
    val value          = config.getString("some-value")
    println(s"SomeTestSpec, some-value = $value")

    value shouldBe "value in api test.conf"
  }
}
