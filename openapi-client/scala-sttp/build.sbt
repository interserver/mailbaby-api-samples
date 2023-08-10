version := "1.0.0"
name := "openapi-client"
organization := "org.openapitools"

scalaVersion := "2.13.10"
crossScalaVersions := Seq(scalaVersion.value, "2.12.17")

libraryDependencies ++= Seq(
  "com.softwaremill.sttp.client3" %% "core" % "2.2.0",
  "com.softwaremill.sttp.client3" %% "json4s" % "2.2.0",
  "org.json4s" %% "json4s-jackson" % "3.6.8"
)

scalacOptions := Seq(
  "-unchecked",
  "-deprecation",
  "-feature"
)
