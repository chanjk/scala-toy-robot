lazy val root = (project in file("."))
  .settings(
    name := "Toy Robot",
    scalaVersion := "2.12.2",
    libraryDependencies += "org.scalatest" %% "scalatest" % "3.0.1" % "test",
    libraryDependencies += "org.scalacheck" %% "scalacheck" % "1.13.4" % "test"
  )
