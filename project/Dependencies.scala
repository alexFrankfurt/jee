import sbt._
import Keys._

object Dependencies {

  val akkaVersion = "2.4.4"

  val akkaActor = "akka-actor"
  val akkaStream = "akka-stream-experimental"
  val akkaHttpCore = "akka-http-core-experimental"
  val akkaHttp = "akka-http-experimental"

  val projectDependencies = Seq(
    "com.typesafe.akka" %% "akka-actor" % akkaVersion,
    "com.typesafe.akka" %% "akka-http-core" % akkaVersion,
    "com.typesafe.akka" %% "akka-http-experimental" % akkaVersion,
    "com.typesafe.akka" %% "akka-stream" % akkaVersion,
    "org.webjars.bower" % "github-com-PolymerElements-paper-button" % "1.0.3",
    "org.webjars.bower" % "github-com-PolymerElements-paper-ripple" % "1.0.2",
    "org.webjars.bower" % "github-com-PolymerElements-paper-material" % "1.0.4",
    "org.webjars.bower" % "github-com-PolymerElements-paper-behaviors" % "1.0.10",
    "org.webjars.bower" % "github-com-PolymerElements-paper-styles" % "1.0.13"
  )
}
