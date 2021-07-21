// code format -> https://github.com/scalameta/sbt-scalafmt
addSbtPlugin("org.scalameta" % "sbt-scalafmt" % "2.4.3")

// automagic scalac options -> https://github.com/DavidGregory084/sbt-tpolecat
addSbtPlugin("io.github.davidgregory084" % "sbt-tpolecat" % "0.1.20")

// protoc to generate code from proto files -> https://github.com/thesamet/sbt-protoc
addSbtPlugin("com.thesamet" % "sbt-protoc" % "1.0.3")

val scalaPB        = "0.11.3"
val zioGrpcVersion = "0.5.0"

libraryDependencies ++= Seq(
  "com.thesamet.scalapb.zio-grpc" %% "zio-grpc-codegen" % zioGrpcVersion,
  "com.thesamet.scalapb"          %% "compilerplugin"   % scalaPB
)
