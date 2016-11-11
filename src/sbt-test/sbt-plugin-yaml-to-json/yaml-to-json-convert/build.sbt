lazy val root = (project in file(".")).enablePlugins(YamlToJsonPlugin)

pairs in YamlToJson := Seq(new File("api.yaml")->new File("target/api.json"))