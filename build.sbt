name := "PaintShop"

version := "1.0"

scalaVersion := "2.11.8"

libraryDependencies += "org.scalatest" % "scalatest_2.11" % "2.2.1" % "test"
libraryDependencies += "com.github.scopt" %% "scopt" % "3.4.0"

libraryDependencies += "org.scala-lang" % "scala-reflect" % "2.11.8"
libraryDependencies += "org.scala-lang.modules" % "scala-xml_2.11" % "1.0.4"

resolvers += Resolver.sonatypeRepo("public")

test in assembly := {}