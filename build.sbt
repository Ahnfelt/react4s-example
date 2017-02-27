enablePlugins(ScalaJSPlugin)

name := "react4s-example"
organization := "com.github.ahnfelt"
version := "0.1-SNAPSHOT"

resolvers += Resolver.sonatypeRepo("snapshots")
libraryDependencies += "com.github.ahnfelt" %%% "react4s" % "0.3-SNAPSHOT"
libraryDependencies += "org.scala-js" %%% "scalajs-dom" % "0.9.0"

scalaVersion := "2.11.0"
