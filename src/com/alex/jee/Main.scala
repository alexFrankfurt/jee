package com.alex.jee

import akka.actor.ActorSystem
import akka.event.Logging
import akka.http.scaladsl.Http
import akka.stream.ActorMaterializer

object Main extends App with Routes {

  implicit val system = ActorSystem("jee")
  implicit val materializer = ActorMaterializer()
  val log = Logging(system, this.getClass)

  Http().bindAndHandle(routes, "localhost", 8080)
}
