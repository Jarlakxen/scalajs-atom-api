name         := "scalajs-atom-api"
organization := "laughedelic"
description  := "Scala.js facades for Atom editor API"

homepage := Some(url(s"https://github.com/laughedelic/${name.value}"))
scmInfo in ThisBuild := Some(ScmInfo(
  homepage.value.get,
  s"scm:git:git@github.com:laughedelic/${name.value}.git"
))

licenses := Seq("MPL-2.0" -> url("https://www.mozilla.org/en-US/MPL/2.0"))
developers := List(Developer(
  "laughedelic",
  "Alexey Alekhin",
  "laughedelic@gmail.com",
  url("https://github.com/laughedelic")
))

scalaVersion := "2.12.4"
scalacOptions ++= Seq(
  "-Yrangepos",
  "-P:scalajs:sjsDefinedByDefault"
)


enablePlugins(ScalaJSPlugin)

scalaJSLinkerConfig ~= { conf =>
  import org.scalajs.core.tools.linker.standard._
  conf
    .withModuleKind(ModuleKind.CommonJSModule)
    .withOutputMode(OutputMode.ECMAScript2015)
}

libraryDependencies += "io.scalajs" %%% "nodejs" % "0.4.2"