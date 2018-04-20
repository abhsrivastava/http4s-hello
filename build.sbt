val http4sVersion = "0.18.9"

val commonSettings = Seq(
  organization := "com.example",
  scalaVersion := "2.12.4",
  version      := "0.1.0-SNAPSHOT",
  libraryDependencies ++= Seq(
    "org.http4s" %% "http4s-core" % http4sVersion,
    "org.http4s" %% "http4s-dsl" % http4sVersion
  )
)
lazy val server = (project in file("server"))
  .settings(commonSettings)
  .settings(
    name := "http4s-hello",
    libraryDependencies ++= Seq(
      "org.http4s" %% "http4s-blaze-server" % http4sVersion,
      "org.http4s" %% "http4s-server" % http4sVersion
    )
  )
lazy val client = (project in file("client"))
  .settings(commonSettings)
  .settings(
    name := "http4s-hello",
    libraryDependencies ++= Seq(
       "org.http4s" %% "http4s-blaze-client" % http4sVersion,
       "org.http4s" %% "http4s-client" % http4sVersion
    )
  )
