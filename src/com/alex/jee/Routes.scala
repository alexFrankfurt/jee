package com.alex.jee

import akka.http.scaladsl
import scaladsl.server.Directives._
import scaladsl.model._
import MediaTypes._

trait Routes {

  val AssetsDir = "target/web/public/main"

  val LibDir = AssetsDir + "/lib"

  val StyleDir = AssetsDir + "/style"

  val ScriptDir = AssetsDir + "/script"

  val PolymerDir = LibDir + "/github-com-Polymer-polymer"

  val WebcomponentsjsDir = LibDir + "/webcomponentsjs"

  val routes =
    (path("/") & get) {
      complete(html.index().toString())
    } ~
    path("hello.html") {
      complete(inner.html.hello().body)
    } ~
    path("hi") {
      get {
        /** 1. Implement marshaller for [[play.twirl.api.HtmlFormat.Appendable]]
         */
        complete(inner.html.some().body)
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
