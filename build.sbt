sbtPlugin := true

//Change to your organization
organization := "nl.rsg.teamaanvragen"

//Change to your plugin name
name := """sbt-yaml-to-json"""

//Change to the version
version := "1.0-SNAPSHOT"

scalaVersion := "2.10.6"

scalacOptions ++= Seq("-deprecation", "-feature")

resolvers += Resolver.sonatypeRepo("snapshots")

// Change this to another test framework if you prefer
libraryDependencies += "org.yaml" % "snakeyaml" % "1.17"
libraryDependencies += "com.gilt" % "jerkson_2.10" % "0.6.9"


// Scripted - sbt plugin tests
scriptedSettings

scriptedLaunchOpts += "-Dproject.version=" + version.value


fork in run := false