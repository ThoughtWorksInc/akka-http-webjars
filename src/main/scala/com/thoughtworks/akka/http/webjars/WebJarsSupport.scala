package com.thoughtworks.ceo.server

import akka.http.scaladsl.server.Directives._
import org.webjars.WebJarAssetLocator

import scala.util.{Failure, Success, Try}

/**
  * @author 杨博 (Yang Bo) &lt;pop.atry@gmail.com&gt;
  */
trait WebJarsSupport {
  protected val webJarAssetLocator = new WebJarAssetLocator

  final def webJars = {
    extractUnmatchedPath { path =>
      Try(webJarAssetLocator.getFullPath(path.toString)) match {
        case Success(fullPath) =>
          getFromResource(fullPath)
        case Failure(_: IllegalArgumentException) =>
          reject
        case Failure(e) =>
          failWith(e)
      }
    }
  }
}

object WebJarsSupport extends WebJarsSupport
