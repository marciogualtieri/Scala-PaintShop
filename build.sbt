name := "PaintShop"

version := "1.0"

scalaVersion := "2.11.8"

libraryDependencies += "org.scalatest" %% "scalatest" % "2.2.1" % "test"
libraryDependencies += "com.github.scopt" %% "scopt" % "3.4.0"
libraryDependencies += "commons-io" % "commons-io" % "2.4"
libraryDependencies += "commons-lang" % "commons-lang" % "2.6"


libraryDependencies += "org.scala-lang" % "scala-reflect" % "2.11.8"
libraryDependencies += "org.scala-lang.modules" %% "scala-xml" % "1.0.4"

resolvers += Resolver.sonatypeRepo("public")