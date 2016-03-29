import Dependencies._

organization in ThisBuild          := "net.liftweb"

version in ThisBuild :=  "2.6.2-MongoAsync2"

homepage in ThisBuild              := Some(url("http://www.liftweb.net"))

licenses in ThisBuild              += ("Apache License, Version 2.0", url("http://www.apache.org/licenses/LICENSE-2.0.txt"))

startYear in ThisBuild             := Some(2006)

organizationName in ThisBuild      := "WorldWide Conferencing, LLC"

scalaVersion in ThisBuild          := "2.11.7"

crossScalaVersions in ThisBuild    := Seq("2.11.7")

libraryDependencies in ThisBuild <++= scalaVersion {sv => Seq(specs2(sv), scalacheck, scalatest(sv)) }

// Settings for Sonatype compliance
pomIncludeRepository in ThisBuild  := { _ => false }

//for local
//publishTo in ThisBuild            <<= isSnapshot(if (_) Some(Opts.resolver.sonatypeSnapshots) else Some(Opts.resolver.sonatypeStaging))

publishTo in ThisBuild := Some(Resolver.file("mvn-repo", new File(Path.userHome + "/git/mvn-repo/")))

scmInfo in ThisBuild               := Some(ScmInfo(url("https://github.com/lift/framework"), "scm:git:https://github.com/lift/framework.git"))

pomExtra in ThisBuild              :=  Developers.toXml

credentials in ThisBuild <+= state map { s => Credentials(BuildPaths.getGlobalSettingsDirectory(s, BuildPaths.getGlobalBase(s)) / ".credentials") }

initialize <<= (name, version, scalaVersion) apply printLogo

resolvers  in ThisBuild           ++= Seq(
  "snapshots"     at "https://oss.sonatype.org/content/repositories/snapshots",
  "releases"      at "https://oss.sonatype.org/content/repositories/releases"
)
