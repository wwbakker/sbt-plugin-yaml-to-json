name := "sbt-yaml-to-json"
description := "sbt plugin for converting yaml files to json within sbt."
organization := "nl.wwbakker"

licenses += ("Apache-2.0", url("https://www.apache.org/licenses/LICENSE-2.0.html"))
sbtPlugin := true
publishMavenStyle := false
bintrayRepository := "sbt-plugins"
// Set to a -SNAPSHOT version when running scripted, non-snapshot version to release.
version := "1.1-SNAPSHOT"

// Change this to another test framework if you prefer
libraryDependencies += "org.yaml" % "snakeyaml" % "1.17"
libraryDependencies += "com.gilt" % "jerkson_2.10" % "0.6.9"

scriptedLaunchOpts := { scriptedLaunchOpts.value ++
  Seq("-Xmx1024M", "-Dplugin.version=" + version.value)
}
scriptedBufferLog := false