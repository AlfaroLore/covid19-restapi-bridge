name := """Covid19-RestAPI-bridge"""
organization := "com.example"

version := "1.0-SNAPSHOT"

lazy val root = (project in file(".")).enablePlugins(PlayJava)

scalaVersion := "2.12.8"

libraryDependencies += guice
libraryDependencies ++= Seq(
  "org.apache.httpcomponents" % "httpclient" % "4.5.12",
  "io.swagger" %% "swagger-play2" % "1.6.1",
  "org.webjars" % "swagger-ui" % "3.25.0"
)