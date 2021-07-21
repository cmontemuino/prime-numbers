import org.scalafmt.sbt.ScalafmtPlugin.autoImport.scalafmtOnCompile
import sbt.Keys.{scalacOptions, _}
import sbt._
import sbt.util.Level

object Settings {
  val commonSettings =
    Seq(
      scalacOptions            := Seq(
        "-Ymacro-annotations",           // Alternative to Macro Paradise compiler plugin for Scala 2.13
        "-deprecation",                  // Emit warning and location for usages of deprecated APIs
        "-encoding",
        "utf-8",                         // Specify character encoding used by source files
        "-explaintypes",                 // Explain type errors in more detail
        "-feature",                      // Emit warning and location for usages of features that should be imported explicitly
        "-unchecked",                    // Enable additional warnings where generated code depends on assumptions
        "-language:postfixOps",
        "-language:higherKinds",         // Allow higher-kinded types
        "-language:implicitConversions", // Allow definition of implicit function called views
        "-Xcheckinit",                   // Wrap field accessors to throw an exception on uninitialized access
        "-Xfatal-warnings"               // Fail the compilation if there are any warnings
      ),
      logLevel                 := Level.Info,
      scalafmtOnCompile        := true,
      ivyLoggingLevel          := UpdateLogging.Quiet, // Reduce verbosity during IVY resolution
      Test / logBuffered       := false,
      Test / parallelExecution := true,
      testFrameworks           := Seq(new TestFramework("zio.test.sbt.ZTestFramework")),
      Global / cancelable      := true,
      Global / fork            := true, // https://github.com/sbt/sbt/issues/2274
      resolvers += "Sonatype OSS Snapshots" at "https://oss.sonatype.org/content/repositories/snapshots"
    )
}
