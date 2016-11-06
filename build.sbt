import Dependencies._

organization in ThisBuild          := "net.liftweb"

version in ThisBuild :=  "2.6.2-MongoAsync-11"

homepage in ThisBuild              := Some(url("http://www.liftweb.net"))

licenses in ThisBuild              += ("Apache License, Version 2.0", url("http://www.apache.org/licenses/LICENSE-2.0.txt"))

startYear in ThisBuild             := Some(2006)

organizationName in ThisBuild      := "WorldWide Conferencing, LLC"

scalaVersion in ThisBuild          := "2.12.0"

crossScalaVersions in ThisBuild    := Seq("2.11.8", "2.12.0")

libraryDependencies in ThisBuild :=  Seq(specs2, scalacheck, scalatest)

// Settings for Sonatype compliance
pomIncludeRepository in ThisBuild  := { _ => false }

//for local
//publishTo in ThisBuild            <<= isSnapshot(if (_) Some(Opts.resolver.sonatypeSnapshots) else Some(Opts.resolver.sonatypeStaging))

publishTo in ThisBuild <<= {
  val nexus = "https://nexus.groupl.es/"
  isSnapshot(if (_) Some("Snapshots" at nexus + "repository/maven-snapshots/") else Some("Releases" at nexus + "repository/maven-releases/"))
}

credentials += Credentials(Path.userHome / ".ivy2" / ".meweCredentials")

initialize <<= (name, version, scalaVersion) apply printLogo

resolvers  in ThisBuild           ++= Seq(
  "snapshots"     at "https://oss.sonatype.org/content/repositories/snapshots",
  "releases"      at "https://oss.sonatype.org/content/repositories/releases"
)
