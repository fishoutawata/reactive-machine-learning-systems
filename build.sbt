name := "serengeti"

version := "0.1"

scalaVersion := "2.11.8"

lazy val Versions = new {
  val phantom = "2.19.1"
  val util = "0.30.1"
  val scalatest = "3.0.4"
}

libraryDependencies ++= Seq(
  "com.outworkers"             %% "phantom-dsl"      % Versions.phantom,
  "com.outworkers"             %% "phantom-streams"  % Versions.phantom,
  "com.outworkers"             %% "util-testing"     % Versions.util % Test,
  "org.scalatest"              %% "scalatest"        % Versions.scalatest % Test
)