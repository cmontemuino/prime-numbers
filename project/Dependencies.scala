import sbt._

object Dependencies {
  lazy val grpcNetty    = "io.grpc"                     % "grpc-netty"      % Version.grpcVersion
  lazy val scalaTest    = "org.scalatest"              %% "scalatest"       % Version.scalaTest % Test
  lazy val logback      = "ch.qos.logback"              % "logback-classic" % Version.logback
  lazy val scalaLogging = "com.typesafe.scala-logging" %% "scala-logging"   % Version.scalaLogging
}

object Version {
  val grpcVersion  = "1.39.0"
  val logback      = "1.2.3"
  val scalaLogging = "3.9.2"
  val scalaTest    = "3.2.9"
}
