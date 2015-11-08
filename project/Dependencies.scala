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
    "org.webjars.bower" % "polymer" % "1.2.1",
    "org.webjars.bower" % "github-com-polymerelements-paper-button" % "1.0.7"
  )
}
