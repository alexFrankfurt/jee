package com.alex.jee

import akka.http.scaladsl
import scaladsl.server.Directives._
import scaladsl.model._
import MediaTypes._

trait Routes {

  val StyleDir = "target/web/stylus/main/style"

  val ScriptDir = "target/web/coffeescript/main/script"

  val PolymerDir = "target/web/public/main/lib"

  val routes =
    (path("/") & get) {
      complete(html.index().toString())
    } ~
    path("hi") {
      get {
        /** 1. Implement marshaller for [[play.twirl.api.HtmlFormat.Appendable]]
         */
        complete(HttpEntity(`text/html`, inner.html.some().body))
      }
    } ~
    path("hello.html") {
      complete(HttpEntity(`text/html`, inner.html.hello().body))
    } ~
    pathPrefix("style") {
      getFromDirectory(StyleDir)
    } ~
    pathPrefix("script") {
      getFromDirectory(ScriptDir)
    } ~
    pathPrefix("lib" / "polymer") {
      getFromDirectory(PolymerDir + "/polymer")
    } ~
    pathPrefix("lib" / "webcomponentsjs") {
      getFromDirectory(PolymerDir + "/webcomponentsjs")
    } ~
    pathPrefix("lib") {
      extractUnmatchedPath { upath =>
        val prefix: String = upath.tail.head.toString
        mapRequestContext(_.mapUnmatchedPath(_.tail.tail)) {
          getFromDirectory(PolymerDir + s"/github-com-polymerelements-$prefix")
        }
      }
    }
}
