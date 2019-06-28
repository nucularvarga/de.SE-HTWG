version       := "0.14.0"
scalaVersion  := "2.12.7"

libraryDependencies += "org.scalactic" %% "scalactic" % "3.0.5"
libraryDependencies += "org.scalatest" %% "scalatest" % "3.0.5" % "test"
libraryDependencies += "org.scalafx" %% "scalafx" % "11-R16"
libraryDependencies += "org.scala-lang.modules" % "scala-swing_2.12" % "2.0.3"
libraryDependencies += "com.google.inject" % "guice" % "4.1.0"
libraryDependencies += "net.codingwell" %% "scala-guice" % "4.1.0"
libraryDependencies += "org.scala-lang.modules" % "scala-xml_2.12" % "1.0.6"
libraryDependencies += "com.typesafe.play" %% "play-json" % "2.6.6"
resolvers += Resolver.sonatypeRepo("snapshots")

scalacOptions ++= Seq("-unchecked", "-deprecation", "-Xcheckinit", "-encoding", "utf8", "-feature")



// Determine OS version of JavaFX binaries
lazy val osName = System.getProperty("os.name") match {
  case n if n.startsWith("Linux") => "linux"
  case n if n.startsWith("Mac") => "mac"
  case n if n.startsWith("Windows") => "win"
  case _ => throw new Exception("Unknown platform!")
}

// Add JavaFX dependencies
val javafxModules = Seq("base", "controls", "fxml", "graphics", "media", "swing", "web")
libraryDependencies ++= javafxModules.map(m => "org.openjfx" % s"javafx-$m" % "11" classifier osName)

// Fork a new JVM for 'run' and 'test:run', to avoid JavaFX double initialization problems
fork := true