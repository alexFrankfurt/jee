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

  val typesafeAkkaRepo = "com.typesafe.akka"

  val projectDependencies = Seq(
    typesafeAkkaRepo %% akkaActor % akkaActorVersion,
    typesafeAkkaRepo %% akkaHttpCore % akkaHttpVersion,
    typesafeAkkaRepo %% akkaHttp % akkaHttpVersion,
    typesafeAkkaRepo %% akkaStream % akkaStreamVersion
  )
}
