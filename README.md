# kafka-sink-source-example

Running the example:
----

1. docker run -d -p 2181:2181 -p 9092:9092 --rm --env ADVERTISED_HOST=kafka --env ADVERTISED_PORT=9092 --name kafka -h kafka spotify/kafka
2. docker build -t "kafka-sink-source-example:latest" ./docker/.
3. docker run -it --name=dev1 --link kafka --volume=/Users/matthew/code/kafka-sink-source-example/:/code/kafka-sink-source-example kafka-sink-source-example
4. cd /code/kafka-sink-source-example
5. sbt "runMain com.jemstep.pattern.producer.PlainSinkProducerMain"

> This will produce 10 messages and exit

6. sbt "runMain com.jemstep.pattern.consumer.PlainSourceConsumerMain"

> This will consume 10 messages and hang around for more

