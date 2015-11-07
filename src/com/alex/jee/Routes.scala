package com.alex.jee

import akka.http.scaladsl
import scaladsl.server.Directives._
import scaladsl.model._
import MediaTypes._

import Main.log

trait Routes {

  val routes =
    (path("/") & get) {
      complete(html.index().toString())
    } ~
    path("hi") {
      get {
        /** 1. Implement marshaller for [[play.twirl.api.HtmlFormat.Appendable]]
         *  2. Manage static resources (css, js).
         */
        complete(HttpEntity(`text/html`, inner.html.some().body))
      }
    } ~
    pathPrefix("web") {
      extractUnmatchedPath { upath =>
        log.info(upath.toString())
        getFromDirectory("target/web")
      }
    }
}
