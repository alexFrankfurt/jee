import Dependencies.projectDependencies
import com.typesafe.sbt.stylus.Import._

lazy val jee = (project in file(".")).enablePlugins(SbtTwirl, SbtWeb).settings(

  name := "jee",

  scalaVersion := "2.11.7",

  scalaSource in Compile := baseDirectory.value / "src",

  javaSource in Compile := baseDirectory.value / "src",

  mainClass := Some("com.alex.jee"),

  libraryDependencies ++= projectDependencies,

  JsEngineKeys.engineType := JsEngineKeys.EngineType.Node,

  includeFilter in (Assets, StylusKeys.stylus) := "*.styl",

  sourceDirectories in (Compile, TwirlKeys.compileTemplates) := Seq(sourceDirectory.value / "web"),

  Revolver.settings

)
