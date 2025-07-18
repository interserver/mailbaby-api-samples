version := "1.0.0"
name := "openapi-client"
organization := "org.openapitools"

scalaVersion := "2.13.16"
val PekkoVersion = "1.0.2"

libraryDependencies ++= Seq(
  "com.typesafe" % "config" % "1.4.3",
  "org.apache.pekko" %% "pekko-actor" % PekkoVersion,
  "org.apache.pekko" %% "pekko-stream" % PekkoVersion,
  "org.apache.pekko" %% "pekko-stream" % PekkoVersion,
  "com.github.pjfanning" %% "pekko-http-json4s" % "2.3.2",
  "org.json4s" %% "json4s-jackson" % "4.0.7",
  "org.json4s" %% "json4s-ext" % "4.0.7",
  // test dependencies
  "org.scalatest"     %% "scalatest"  % "3.2.17"   % "test",
  "org.scalatestplus" %% "junit-4-13" % "3.2.17.0" % "test"
)

resolvers ++= Seq(Resolver.mavenLocal)

scalacOptions := Seq(
  "-unchecked",
  "-deprecation",
  "-feature"
)

Compile / packageDoc / publishArtifact := false
