package com.jemstep.pattern.producer

import akka.actor.ActorSystem
import akka.kafka.ProducerSettings
import akka.kafka.scaladsl.Producer
import akka.stream.ActorMaterializer
import akka.stream.scaladsl.Source
import org.apache.kafka.clients.producer.ProducerRecord
import org.apache.kafka.common.serialization.{ByteArraySerializer, StringSerializer}
import scala.concurrent.Await
import scala.concurrent.duration._

/**
  * Created by marksu on 8/31/16.
  */
object PlainSinkProducerMain extends App {

  implicit val system = ActorSystem("PlainSinkProducerMain")
  implicit val materializer = ActorMaterializer()

  val producerSettings = ProducerSettings(system, new ByteArraySerializer, new StringSerializer)
    .withBootstrapServers("kafka:9092")

  val done = Source(1 to 10)
    .map(_.toString)
    .map { elem =>
      println(s"PlainSinkProducer produce: ${elem}")
      new ProducerRecord[Array[Byte], String]("topic1", elem)
    }
    .runWith(Producer.plainSink(producerSettings))

  Await.result(done, 5000 millis);
  system.terminate

}