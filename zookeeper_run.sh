#!/bin/bash
#/home/pi/Smart_home_projekt_inzynierski/kafka_2.12-2.6.0/bin/zookeeper-server-start.sh /home/pi/Smart_home_projekt_inzynierski/kafka_2.12-2.6.0/config/zookeeper.properties &
#/home/pi/Smart_home_projekt_inzynierski/kafka_2.12-2.6.0/bin/kafka-server-start.sh /home/pi/Smart_home_projekt_inzynierski/kafka_2.12-2.6.0/config/server.properties &
#/home/pi/Smart_home_projekt_inzynierski/kafka_2.12-2.6.0/bin/kafka-topics.sh --create --bootstrap-server 192.168.0.18:9092 --replication-factor 1 --partitions 1 --topic TestTopic
/home/pi/Smart_home_projekt_inzynierski/kafka/bin/zookeeper-server-start.sh /home/pi/Smart_home_projekt_inzynierski/kafka/config/zookeeper.properties
#/home/pi/Smart_home_projekt_inzynierski/kafka/bin/kafka-server-start.sh /home/pi/Smart_home_projekt_inzynierski/kafka/config/server.properties &
#/home/pi/Smart_home_projekt_inzynierski/kafka/bin/kafka-topics.sh --create --bootstrap-server 192.168.0.18:9092 --replication-factor 1 --partitions 1 --topic TestTopic &
