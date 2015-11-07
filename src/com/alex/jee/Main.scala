package com.alex.jee

import akka.actor.ActorSystem
import akka.event.Logging
import akka.http.scaladsl.Http
import akka.stream.ActorMaterializer

object Main extends App with Routes{

  println("OK")
  println(inner.html.some ())

  implicit val system = ActorSystem("jee")
  val log = Logging(system, this.getClass)
  implicit val materializer = ActorMaterializer()

  Http().bindAndHandle(routes, "localhost", 8080)
}
