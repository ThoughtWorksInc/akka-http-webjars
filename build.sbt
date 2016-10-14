organization in ThisBuild := "com.thoughtworks.akka-http-webjars"

crossScalaVersions in ThisBuild := Seq("2.10.6", "2.11.8", "2.12.0-RC1")

libraryDependencies += "org.webjars" % "webjars-locator" % "0.32"

libraryDependencies += "com.typesafe.akka" %% "akka-http-experimental" % "2.0.4"
