import Dependencies._
import Settings._

ThisBuild / version          := "0.1.0-SNAPSHOT"
ThisBuild / organization     := "com.github"
ThisBuild / organizationName := "cmontemuino"
ThisBuild / scalaVersion     := "2.13.6"

lazy val protos = project
  .in(file("protos"))
  .disablePlugins(TpolecatPlugin) // this module cannot cope with scalac options from sbt-tpolecat
  .settings(
    Compile / PB.targets      := Seq(
      scalapb.gen(grpc = true)          -> (Compile / sourceManaged).value,
      scalapb.zio_grpc.ZioCodeGenerator -> (Compile / sourceManaged).value
    ),
    Compile / PB.protoSources := Seq(
      (ThisBuild / baseDirectory).value / "protos" / "src" / "main" / "protobuf"
    )
  )
  .settings(
    libraryDependencies ++= Seq(
      "com.thesamet.scalapb" %%% "scalapb-runtime-grpc" % scalapb.compiler.Version.scalapbVersion
    )
  )

lazy val server = project
  .dependsOn(protos)
  .settings(commonSettings)
  .settings(
    name := "server",
    libraryDependencies ++= Seq(grpcNetty)
  )
