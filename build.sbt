organization in ThisBuild := "com.thoughtworks.akka-http-webjars"

libraryDependencies += "org.webjars" % "webjars-locator" % "0.36"

libraryDependencies += "com.typesafe.akka" %% "akka-http" % "10.1.8"

libraryDependencies += "com.typesafe.akka" %% "akka-stream" % "2.5.21" % Optional
