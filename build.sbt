import Dependencies.projectDependencies
import com.typesafe.sbt.stylus.Import._

name := "jee"

scalaVersion := "2.11.7"

sourceDirectory in Compile := baseDirectory.value / "src"

scalaSource in Compile := (sourceDirectory in Compile).value

javaSource in Compile := (sourceDirectory in Compile).value

mainClass := Some("com.alex.jee")

libraryDependencies ++= projectDependencies

JsEngineKeys.engineType := JsEngineKeys.EngineType.Node

includeFilter in (Assets, StylusKeys.stylus) := "*.styl"

sourceDirectories in (Compile, TwirlKeys.compileTemplates) := Seq(sourceDirectory.value / "web")

Revolver.settings

lazy val jee = (project in file(".")).enablePlugins(SbtTwirl, SbtWeb)
