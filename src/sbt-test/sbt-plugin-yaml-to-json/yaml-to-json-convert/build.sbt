lazy val root = (project in file("."))

yamlToJsonPairs in YamlToJson := Seq(new File("api.yaml")->new File("target/api.json"))