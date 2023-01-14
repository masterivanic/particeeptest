import sbt._

object Dependencies {
  lazy val scalaTest = "org.scalatest" %% "scalatest" % "3.2.9"
  lazy val vavr = "io.vavr" % "vavr"            % "0.10.4" withSources ()
}
