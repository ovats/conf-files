import com.domain.User
import com.typesafe.config.{Config, ConfigFactory}

object MainApp extends App {

  val u = User("someone", 20)
  println(s"User = $u")

  // print data from configuration file
  val config: Config = ConfigFactory.load()
  val value          = config.getString("some-value")
  println(s"some-value = $value")
}
