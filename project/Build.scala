import sbt._
import Keys._
import play.Project._
// sbt-scalariform
import com.typesafe.sbt.SbtScalariform._
import scalariform.formatter.preferences._
// sbt-dependecy-graph
import net.virtualvoid.sbt.graph.Plugin._

object ApplicationBuild extends Build {

  val appName         = "play-angular-phonecat"
  val appVersion      = "0.0"

  val appDependencies = Seq(
    "io.argonaut" %% "argonaut" % "6.0-RC3",
    "org.scalaz" %% "scalaz-core" % "7.0.2",
    "org.scalaz" %% "scalaz-effect" % "7.0.2",
    // Bump dependencies
    "com.typesafe.akka" %% "akka-actor" % "2.1.4",
    "com.typesafe.akka" %% "akka-slf4j" % "2.1.4",
    // Test
    "com.typesafe.akka" %% "akka-testkit" % "2.1.4" % "test",
    "org.specs2" %% "specs2" % "2.0" % "test"
  )

  val main = play.Project(appName, appVersion, appDependencies).settings(
    scalariformSettings : _*
  ).settings(
    graphSettings: _*
  ).settings(
    scalaVersion := "2.10.2",
    scalacOptions ++= compileSettings,
    resolvers ++= projectResolvers,
    ScalariformKeys.preferences := formattingSettings
  )

  lazy val compileSettings = Seq(
    "-unchecked", "-deprecation", "-encoding", "utf8", "-feature"
  )

  lazy val formattingSettings =
    FormattingPreferences()
      .setPreference(AlignParameters, true)
      .setPreference(AlignSingleLineCaseStatements, false)
      .setPreference(AlignSingleLineCaseStatements.MaxArrowIndent, 40)
      .setPreference(CompactControlReadability, false)
      .setPreference(CompactStringConcatenation, false)
      .setPreference(DoubleIndentClassDeclaration, true)
      .setPreference(FormatXml, true)
      .setPreference(IndentLocalDefs, false)
      .setPreference(IndentPackageBlocks, true)
      .setPreference(IndentSpaces, 2)
      .setPreference(IndentWithTabs, false)
      .setPreference(MultilineScaladocCommentsStartOnFirstLine, false)
      .setPreference(PlaceScaladocAsterisksBeneathSecondAsterisk, false)
      .setPreference(PreserveSpaceBeforeArguments, false)
      .setPreference(PreserveDanglingCloseParenthesis, true)
      .setPreference(RewriteArrowSymbols, true)
      .setPreference(SpaceBeforeColon, false)
      .setPreference(SpaceInsideBrackets, false)
      .setPreference(SpaceInsideParentheses, false)
      .setPreference(SpacesWithinPatternBinders, true)

  lazy val projectResolvers = Seq(
    "Sonatype OSS Releases" at "http://oss.sonatype.org/content/repositories/releases/",
    "Sonatype OSS Snapshots" at "http://oss.sonatype.org/content/repositories/snapshots/"
  )
}
