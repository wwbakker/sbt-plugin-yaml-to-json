package nl.rsg.teamaanvragen

import sbt._
import sbt.Keys.streams

import com.codahale.jerkson.Json._
import org.yaml.snakeyaml.Yaml


/**
 * This plugin helps you which operating systems are awesome
 */
object YamlToJsonPlugin extends AutoPlugin {

  /**
   * Defines all settings/tasks that get automatically imported,
   * when the plugin is enabled
   */
  object autoImport {
    val YamlToJson : Configuration = Configuration("yaml-to-json", "YamlToJson specific properties", isPublic=true, Nil, transitive=true)

    val convert = taskKey[Unit]("task for converting yaml to json")
    val pairs = settingKey[Seq[Tuple2[File, File]]]("Input YAML and output JSON files as pairs.")

    lazy val baseYamlToJsonSettings : Seq[Def.Setting[_]] = Seq(
      pairs := Nil,
      convert := yamlToJsonImpl.value
    )
  }

  import autoImport._

  lazy val yamlToJsonImpl : Def.Initialize[Task[Unit]] = Def.task {
    val s = streams.value
    pairs.value.foreach {
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

    if (pairs.value.isEmpty)
      s.log.warn("No yaml files to convert. Property 'yamlAndJsonPairs' is not set.")
  }

  /**
    * Provide default settings
    */
  override val projectSettings : Seq[Setting[_]] =
    inConfig(YamlToJson)(baseYamlToJsonSettings)

}
