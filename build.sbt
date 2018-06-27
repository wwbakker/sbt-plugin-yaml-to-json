sbtPlugin := true

//Change to your organization
organization := "nl.wwbakker"

//Change to your plugin name
name := """sbt-yaml-to-json"""

//Change to the version
version := "1.0"

// Change this to another test framework if you prefer
libraryDependencies += "org.yaml" % "snakeyaml" % "1.17"
libraryDependencies += "com.gilt" % "jerkson_2.10" % "0.6.9"


//// Scripted - sbt plugin tests
//scriptedSettings

scriptedLaunchOpts := { scriptedLaunchOpts.value ++
  Seq("-Xmx1024M", "-Dplugin.version=" + version.value)
}
scriptedBufferLog := false