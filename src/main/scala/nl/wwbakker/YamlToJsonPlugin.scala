package nl.wwbakker

import sbt._
import sbt.Keys.streams

import com.codahale.jerkson.Json._
import org.yaml.snakeyaml.Yaml


/**
 * This plugin helps you which operating systems are awesome
 */
object YamlToJsonPlugin extends AutoPlugin {
  override def trigger = allRequirements

  /**
   * Defines all settings/tasks that get automatically imported,
   * when the plugin is enabled
   */
  object autoImport {
    lazy val YamlToJson : Configuration = config("yaml-to-json")

    lazy val yamlToJsonConvert = taskKey[Unit]("task for converting yaml to json")
    lazy val yamlToJsonPairs = settingKey[Seq[(File, File)]]("Input YAML and output JSON files as pairs.")
    lazy val baseYamlToJsonSettings : Seq[Def.Setting[_]] = Seq(
      yamlToJsonPairs := Nil,
      yamlToJsonConvert := yamlToJsonImpl.value
    )
  }

  import autoImport._

  lazy val yamlToJsonImpl : Def.Initialize[Task[Unit]] = Def.task {
    val s = streams.value
    yamlToJsonPairs.value.foreach {
      case (inputFile, _) if !inputFile.exists() =>
        s.log.error("Cannot convert Yaml to Json. Input file does not exist at '" + inputFile.toString + "'")
      case (inputFile, outputFile) =>
        if (outputFile.exists())
          outputFile.delete()
        s.log.info("Converting '" + inputFile.toString + "' to '" + outputFile.toString + "'.")
        val yamlMap = (new Yaml).load(IO.read(inputFile))
        val jsonString = generate(yamlMap)
        IO.write(outputFile, jsonString.getBytes("utf-8"))
    }

    if (yamlToJsonPairs.value.isEmpty)
      s.log.warn("No yaml files to convert. Property 'yamlAndJsonPairs' is not set.")
  }

  /**
    * Provide default settings
    */
  override val projectSettings : Seq[Setting[_]] =
    inConfig(YamlToJson)(baseYamlToJsonSettings)

}
