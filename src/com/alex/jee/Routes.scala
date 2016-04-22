package com.alex.jee

import akka.http.scaladsl
import scaladsl.server.Directives._

trait Routes extends Marshallers { self: Main.type =>

  val AssetsDir = "target/web"

  val LibDir = AssetsDir + "/web-modules/main/webjars/lib"

  val StyleDir = AssetsDir + "/stylus/main/style"

  val ScriptDir = AssetsDir + "/coffeescript/main/script"

  val PolymerDir = LibDir + "/github-com-Polymer-polymer"

  val WebcomponentsjsDir = LibDir + "/webcomponentsjs"

  val routes =
    (pathSingleSlash & get) {
      log.info("get to root path")
      complete(html.index())
    } ~
    path("hello.html") {
      complete(inner.html.hello())
    } ~
    path("hi") {
      get {
        /** 1. Implement marshaller for [[play.twirl.api.HtmlFormat.Appendable]]
         */
        complete(inner.html.some())
      }
    } ~
    pathPrefix("style") {
      getFromDirectory(StyleDir)
    } ~
    pathPrefix("script") {
      getFromDirectory(ScriptDir)
    } ~
    pathPrefix("lib" / "polymer") {
      getFromDirectory(PolymerDir)
    } ~
    pathPrefix("lib" / "webcomponentsjs") {
      getFromDirectory(WebcomponentsjsDir)
    } ~
    pathPrefix("lib") {
      extractUnmatchedPath { upath =>
        val prefix: String = upath.tail.head.toString
        mapRequestContext(_.mapUnmatchedPath(_.tail.tail)) {
          getFromDirectory(LibDir + s"/github-com-PolymerElements-$prefix")
        }
      }
    }
}
