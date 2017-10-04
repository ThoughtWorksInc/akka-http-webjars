val currentScalaVersion = "2.11.11"

organization in ThisBuild := "com.thoughtworks.akka-http-webjars"

scalaVersion in ThisBuild := currentScalaVersion

crossScalaVersions in ThisBuild := Seq(currentScalaVersion, "2.12.3")

libraryDependencies += "org.webjars" % "webjars-locator" % "0.32"

libraryDependencies += "com.typesafe.akka" %% "akka-http" % "10.0.10"
