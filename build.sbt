ThisBuild / version := "0.1.0-SNAPSHOT"

ThisBuild / scalaVersion := "3.3.1"

lazy val root = (project in file("."))
  .settings(
    name := "datastructures",
    idePackagePrefix := Some("ca.pinesoul"),
    libraryDependencies += "org.scalatest" %% "scalatest" % "3.2.15" % Test
  )
