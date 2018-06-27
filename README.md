# sbt plugin for converting yaml to json

## Introduction
Provides a way for sbt to convert *.yaml files to *.json files.
## Usage
Add the plugin to your project.
a `[yoursbtproject]/project/plugins.sbt` file. In there add:
```sbt
resolvers += Resolver.bintrayIvyRepo("wwbakker", "sbt-plugins")
addSbtPlugin("nl.wwbakker" % "sbt-yaml-to-json" % "1.0")
```
Configure which files to convert:
```sbt
yamlToJsonPairs in YamlToJson := Seq(new File("api.yaml")->new File("target/api.json"))
```

Now, in your project you can call `yaml-to-json:convert` to convert the configured files.
```
> yaml-to-json:yamlToJsonConvert
[info] [info] Converting 'api.yaml' to 'target\api.json'.
[info] [success] Total time: 0 s, completed 27-jun-2018 19:05:10
```
## Run plugin test-suite
To run the testsuite for this code, start sbt and run the scripted command.
```sbt
sbt:sbt-yaml-to-json> scripted
[info] Packaging sbt-yaml-to-json-1.0-SNAPSHOT.jar ...
[info] Done packaging.
[info] :: delivering :: nl.wwbakker#sbt-yaml-to-json;1.0-SNAPSHOT :: 1.0-SNAPSHOT :: integration :: Wed Jun 27 19:04:52 CEST 2018
[info]  delivering ivy file to .\sbt-plugin-yaml-to-json\target\scala-2.12\sbt-1.0\ivy-1.0-SNAPSHOT.xml
[info]  published sbt-yaml-to-json to C:\Users\Wessel\.ivy2\local\nl.wwbakker\sbt-yaml-to-json\scala_2.12\sbt_1.0\1.0-SNAPSHOT\jars\sbt-yaml-to-json.jar
[info]  published sbt-yaml-to-json to C:\Users\Wessel\.ivy2\local\nl.wwbakker\sbt-yaml-to-json\scala_2.12\sbt_1.0\1.0-SNAPSHOT\srcs\sbt-yaml-to-json-sources.jar
[info]  published sbt-yaml-to-json to C:\Users\Wessel\.ivy2\local\nl.wwbakker\sbt-yaml-to-json\scala_2.12\sbt_1.0\1.0-SNAPSHOT\docs\sbt-yaml-to-json-javadoc.jar
[info]  published ivy to C:\Users\Wessel\.ivy2\local\nl.wwbakker\sbt-yaml-to-json\scala_2.12\sbt_1.0\1.0-SNAPSHOT\ivys\ivy.xml
Running sbt-plugin-yaml-to-json / yaml-to-json-convert
[error] Getting org.fusesource.jansi jansi 1.11  (this may take some time)...
[info] :: retrieving :: org.scala-sbt#boot-jansi
[info]  confs: [default]
[info]  1 artifacts copied, 0 already retrieved (111kB/18ms)
[error] Getting org.scala-sbt sbt 1.1.6  (this may take some time)...
[info] :: retrieving :: org.scala-sbt#boot-app
[info]  confs: [default]
[info]  76 artifacts copied, 0 already retrieved (27669kB/1758ms)
[error] Getting Scala 2.12.6 (for sbt)...
[info] :: retrieving :: org.scala-sbt#boot-scala
[info]  confs: [default]
[info]  5 artifacts copied, 0 already retrieved (19632kB/64ms)
[info] [info] Loading settings from plugins.sbt ...
[info] [info] Loading project definition from C:\Users\Wessel\AppData\Local\Temp\sbt_ff6bc1b6\yaml-to-json-convert\project
[info] [info] Updating ProjectRef(uri("file:/C:/Users/Wessel/AppData/Local/Temp/sbt_ff6bc1b6/yaml-to-json-convert/project/"), "yaml-to-json-convert-build")...
[info] [warn] Choosing local for nl.wwbakker#sbt-yaml-to-json;1.0-SNAPSHOT
[info] [info] Done updating.
[info] [info] Loading settings from build.sbt ...
[info] [info] Set current project to root (in build file:/C:/Users/Wessel/AppData/Local/Temp/sbt_ff6bc1b6/yaml-to-json-convert/)
[info] [success] Total time: 0 s, completed 27-jun-2018 19:05:10
[info] [info] Converting 'api.yaml' to 'target\api.json'.
[info] [success] Total time: 0 s, completed 27-jun-2018 19:05:10
[info] + sbt-plugin-yaml-to-json / yaml-to-json-convert
[success] Total time: 19 s, completed 27-jun-2018 19:05:11
```