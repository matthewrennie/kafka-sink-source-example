import sbt._

object Dependencies {

  val akkaVersion = "2.5.8"
  
  lazy val scalaTest = "org.scalatest" %% "scalatest" % "3.0.3"
  lazy val akkaActor = "com.typesafe.akka" %% "akka-actor" % akkaVersion
  lazy val akkaTestkit = "com.typesafe.akka" %% "akka-testkit" % akkaVersion
  lazy val akkaStreamKafka = "com.typesafe.akka" %% "akka-stream-kafka" % "0.18"
}
