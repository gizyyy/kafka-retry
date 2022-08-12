package com.example.kafkaadvance;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.kafka.annotation.EnableKafka;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
@EnableKafka
public class KafkaRetryApplication {

	public static void main(String[] args) {
		SpringApplication.run(KafkaRetryApplication.class, args);
	}

}
