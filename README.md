# sbt plugin for converting json to yaml

## Introduction
Provides a way for sbt to convert *.yaml files to *.json files.
## Usage
To get this to work, first import the plugin into your project. Create or use
a `[yoursbtproject]/project/plugins.sbt` file. In there add:
```sbt
addSbtPlugin("nl.rsg.teamaanvragen" % "sbt-yaml-to-json" % "1.0-SNAPSHOT")
```
Then, in your `[yoursbtproject]/build.sbt` file, enable the plugin:
```sbt
lazy val root = (project in file(".")).enablePlugins(YamlToJsonPlugin)
```
Finally, configure which files to convert:
```sbt
pairs in YamlToJson := Seq(new File("api.yaml")->new File("target/api.json"))
```

Now, in your project you can call `yaml-to-json:convert` to convert the configured files.
```sbt
> yaml-to-json:convert
[info] Converting 'api.yaml' to 'target/api.json'.
[success] Total time: 0 s, completed 11-nov-2016 11:27:57
```
## Run plugin test-suite
To run the testsuite for this code, start sbt and run the scripted command.
```
./bin/activator
[info] Loading project definition from sbt-plugin-yaml-to-json/
[info] Set current project to sbt-yaml-to-json (in build file:/sbt-plugin-yaml-to-json/)
> scripted
[info] Wrote sbt-plugin-yaml-to-json/target/scala-2.10/sbt-0.13/sbt-yaml-to-json-1.0-SNAPSHOT.pom
[info] :: delivering :: nl.rsg.teamaanvragen#sbt-yaml-to-json;1.0-SNAPSHOT :: 1.0-SNAPSHOT :: integration :: Fri Nov 11 11:40:20 CET 2016
[info]  delivering ivy file to sbt-plugin-yaml-to-json/target/scala-2.10/sbt-0.13/ivy-1.0-SNAPSHOT.xml
[info] Packaging sbt-plugin-yaml-to-json/target/scala-2.10/sbt-0.13/sbt-yaml-to-json-1.0-SNAPSHOT.jar ...
[info] Done packaging.
[info]  published sbt-yaml-to-json to ~/.ivy2/local/nl.rsg.teamaanvragen/sbt-yaml-to-json/scala_2.10/sbt_0.13/1.0-SNAPSHOT/poms/sbt-yaml-to-json.pom
[info]  published sbt-yaml-to-json to ~/.ivy2/local/nl.rsg.teamaanvragen/sbt-yaml-to-json/scala_2.10/sbt_0.13/1.0-SNAPSHOT/jars/sbt-yaml-to-json.jar
[info]  published sbt-yaml-to-json to ~/.ivy2/local/nl.rsg.teamaanvragen/sbt-yaml-to-json/scala_2.10/sbt_0.13/1.0-SNAPSHOT/srcs/sbt-yaml-to-json-sources.jar
[info]  published sbt-yaml-to-json to ~/.ivy2/local/nl.rsg.teamaanvragen/sbt-yaml-to-json/scala_2.10/sbt_0.13/1.0-SNAPSHOT/docs/sbt-yaml-to-json-javadoc.jar
[info]  published ivy to ~/.ivy2/local/nl.rsg.teamaanvragen/sbt-yaml-to-json/scala_2.10/sbt_0.13/1.0-SNAPSHOT/ivys/ivy.xml
Running sbt-plugin-yaml-to-json / yaml-to-json-convert
[success] Total time: 17 s, completed 11-nov-2016 11:40:37
```
This means that the test succeeded. For more informationa about testing sbt plugins:
http://eed3si9n.com/testing-sbt-plugins