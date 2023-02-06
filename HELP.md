zookeeper-server-start D:\softwares\kafka\config\zookeeper.properties

kafka-server-start D:\softwares\kafka\config\server.properties


kafka-console-consumer --topic wikimedia_recentchange --from-beginning --bootstrap-server localhost:9092
