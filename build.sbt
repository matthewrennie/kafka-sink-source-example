import Dependencies._

lazy val root = (project in file(".")).
  settings(
    inThisBuild(List(
      organization := "com.jemstep",
      scalaVersion := "2.12.3",
      version      := "0.1.0-SNAPSHOT"
    )),
    name := "archetype-scala-kafka-service-patterns",
    libraryDependencies += scalaTest % Test,
    libraryDependencies ++= Seq(akkaActor, akkaTestkit, akkaStreamKafka)
  )
