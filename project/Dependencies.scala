import sbt._
import Keys._

object Dependencies {
  val akkaActorVersion = "2.4.0"
  val akkaHttpVersion = "1.0"
  val akkaStreamVersion = "1.0"

  val akkaActor = "akka-actor"
  val akkaStream = "akka-stream-experimental"
  val akkaHttpCore = "akka-http-core-experimental"
  val akkaHttp = "akka-http-experimental"

  val projectDependencies = Seq(
    "com.typesafe.akka" %% akkaActor % akkaActorVersion,
    "com.typesafe.akka" %% akkaHttpCore % akkaHttpVersion,
    "com.typesafe.akka" %% akkaHttp % akkaHttpVersion,
    "com.typesafe.akka" %% akkaStream % akkaStreamVersion,
    "org.webjars.bower" % "github-com-PolymerElements-paper-button" % "1.0.3",
    "org.webjars.bower" % "github-com-PolymerElements-paper-ripple" % "1.0.2",
    "org.webjars.bower" % "github-com-PolymerElements-paper-material" % "1.0.4",
  "org.webjars.bower" % "github-com-PolymerElements-paper-behaviors" % "1.0.10",
    "org.webjars.bower" % "github-com-PolymerElements-paper-styles" % "1.0.13"
  )
}
