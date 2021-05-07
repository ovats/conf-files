name := "conf-files"

version := "0.1"

scalaVersion := "2.13.5"

// Unit tests and integration tests configurations:
lazy val IntegrationTests = config("test-int") extend Test

def itFilter(name: String): Boolean   = name endsWith "ISpec"
def unitFilter(name: String): Boolean = (name endsWith "Spec") && !itFilter(name)

lazy val integrationTestSettings = Seq(
  IntegrationTests / javaOptions += "-Dconfig.resource=/test-int.conf",
  IntegrationTests / testOptions := Seq(Tests.Filter(itFilter)),
)

lazy val testSettings = Seq(
  Test / javaOptions += "-Dconfig.resource=/test.conf",
  Test / testOptions := Seq(Tests.Filter(unitFilter)),
)

// Project configurations:
lazy val `conf-files` = (project in file("."))
  .aggregate(
    `domain`,
    `api`,
  )

lazy val `api` = project
  .dependsOn(`domain`)
//  .dependsOn(`domain` % "compile->compile;test->test")
  .settings(commonSettings: _*)
  .configs(IntegrationTests)
  .settings(inConfig(Test)(testSettings): _*)
  .settings(inConfig(IntegrationTests)(Defaults.testTasks): _*)
  .settings(inConfig(IntegrationTests)(integrationTestSettings): _*)
  .settings(
    libraryDependencies ++= Seq("org.scalatest" %% "scalatest" % "3.2.3" % Test, "com.typesafe" % "config" % "1.4.1")
  )

lazy val `domain` = project
  .settings(commonSettings: _*)
  .configs(IntegrationTests)
  .settings(inConfig(Test)(testSettings): _*)
  .settings(inConfig(IntegrationTests)(Defaults.testTasks): _*)
  .settings(inConfig(IntegrationTests)(integrationTestSettings): _*)
  .settings(
    libraryDependencies ++= Seq("org.scalatest" %% "scalatest" % "3.2.3" % Test, "com.typesafe" % "config" % "1.4.1")
  )

lazy val commonSettings = Seq(
  publish := {}
)
