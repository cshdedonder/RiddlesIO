name := "RiddlesIO"

version := "0.1"

scalaVersion := "2.12.8"

libraryDependencies += "org.typelevel" %% "cats-effect" % "1.0.0" withSources() withJavadoc()
libraryDependencies += "org.typelevel" %% "cats-core" % "1.6.0" withSources() withJavadoc()

scalacOptions ++= Seq(
  "-feature",
  "-deprecation",
  "-unchecked",
  "-language:postfixOps",
  "-language:higherKinds",
  "-Ypartial-unification")