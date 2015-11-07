package com.alex.jee

import akka.http.scaladsl
import akka.http.scaladsl.model.Uri.Path
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
    path("hello.html") {
      complete(HttpEntity(`text/html`, inner.html.hello().body))
    } ~
    pathPrefix("web") {
      extractUnmatchedPath { upath =>
        log.info(upath.toString())
        getFromDirectory("target/web")
      }
    } ~
    pathPrefix("main" / "lib" / "polymer") {
      extractUnmatchedPath { upath =>
        log.info(upath.toString() + "pol-get")
        getFromDirectory("target/web/public/main/lib/polymer")
      }
    } ~
    pathPrefix("main" / "lib" / "webcomponentsjs") {
      extractUnmatchedPath { upath =>
        log.info(upath.toString() + "webcomp-get")
        getFromDirectory("target/web/public/main/lib/webcomponentsjs")
      }
    } ~
    pathPrefix("main" / "lib") {
      extractUnmatchedPath { upath =>
        val suffix: String = upath.tail.head.toString
        mapRequestContext(_.mapUnmatchedPath(_.tail.tail)) {
          extractUnmatchedPath {upath =>
            log.info(upath.toString())
            getFromDirectory(s"target/web/public/main/lib/github-com-polymerelements-$suffix")
          }
        }
      }
    }
//    path("main/lib/iron-flex-layout") {
//      getFromDirectory("target/web/public/main/lib/github-com-PolymerElements-iron-flex-layout")
//    } ~
//    path("main/lib/paper-button/") {
//      extractUnmatchedPath { upath =>
//        log.info("getting paper-button")
//        getFromDirectory("target/web/public/main/lib/github-com-polymerelements-paper-button")
//      }
//    }~
//    path("main/lib/paper-material") {
//      getFromDirectory("target/web/public/main/lib/github-com-polymerelements-paper-material")
//    } ~
//    path("main/lib/paper-ripple") {
//      getFromDirectory("target/web/public/main/lib/github-com-polymerelements-paper-ripple")
//    } ~
//    path("main/lib/paper-behaviors") {
//      getFromDirectory("target/web/public/main/lib/github-com-polymerelements-paper-behaviors")
//    } ~
//    pathPrefix("main" / "lib") {
//      extractUnmatchedPath { upath =>
//        pathPrefix("webcomponentsjs") {
//          extractUnmatchedPath { upath =>
//            getFromDirectory("target/web/public/main/lib/webcomponents")
//          }
//        } ~
//        pathPrefix("polymer") {
//          extractUnmatchedPath { upath =>
//            getFromDirectory("target/web/public/main/lib/polymer")
//          }
//        } ~
//        pathPrefix("paper-button") {
//          extractUnmatchedPath { upath =>
//            getFromDirectory("target/web/public/main/lib/github-com-polymerelements-paper-button")
//          }
//        } ~
//        pathPrefix("paper-material") {
//          extractUnmatchedPath { upath =>
//            getFromDirectory("target/web/public/main/lib/github-com-polymerelements-paper-material")
//          }
//        } ~
//        pathPrefix("paper-ripple") {
//          extractUnmatchedPath { upath =>
//            getFromDirectory("target/web/public/main/lib/github-com-polymerelements-paper-ripple")
//          }
//        } ~
//        pathPrefix("paper-behaviors") {
//          extractUnmatchedPath { upath =>
//            getFromDirectory("target/web/public/main/lib/github-com-polymerelements-paper-behaviors")
//          }
//        } ~
//        pathPrefix("iron-flex-layout") {
//          extractUnmatchedPath { upath =>
//            getFromDirectory("target/web/public/main/lib/github-com-PolymerElements-iron-flex-layout")
//          }
//        }
//      }
//    }
}
