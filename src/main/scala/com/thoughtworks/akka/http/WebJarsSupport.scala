package com.thoughtworks.modularizer.server

import akka.http.scaladsl.server.Directives._
import akka.http.scaladsl.server.Route
import org.webjars.WebJarAssetLocator

import scala.util.{Failure, Success, Try}

/**
  * @author 杨博 (Yang Bo)
  */
trait WebJarsSupport {
  val webJarAssetLocator = new WebJarAssetLocator

  final def sbtWebLayout: Route = {
    pathPrefix("lib") {
      pathPrefix(Segment) {
        webJars
      }
    } ~ webJars
  }

  final def webJars(webJarName: String): Route = {
    extractUnmatchedPath { path =>
      Try(webJarAssetLocator.getFullPath(webJarName, path.toString)) match {
        case Success(fullPath) =>
          getFromResource(fullPath)
        case Failure(_: IllegalArgumentException) =>
          reject
        case Failure(e) =>
          failWith(e)
      }
    }
  }

  final def webJars: Route = {
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
