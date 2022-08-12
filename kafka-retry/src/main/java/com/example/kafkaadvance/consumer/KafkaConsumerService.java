package com.example.kafkaadvance.consumer;

import org.springframework.kafka.annotation.DltHandler;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.annotation.RetryableTopic;
import org.springframework.kafka.retrytopic.TopicSuffixingStrategy;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.handler.annotation.Header;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.retry.annotation.Backoff;
import org.springframework.stereotype.Service;

import com.example.kafkaadvance.config.KafkaMessage;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class KafkaConsumerService {

	@RetryableTopic(attempts = "4", include = {
			RuntimeException.class }, backoff = @Backoff(delay = 1000, multiplier = 2.0), autoCreateTopics = "false", topicSuffixingStrategy = TopicSuffixingStrategy.SUFFIX_WITH_INDEX_VALUE)
	@KafkaListener(topics = "${kafka.topic.name}", groupId = "group", concurrency = "2")
	public void listen(@Payload KafkaMessage kafkaMessage, @Header(KafkaHeaders.RECEIVED_TOPIC) String topic) {
		System.out.println(String.format("Message received to retry from %s  %s - %s", topic,
				kafkaMessage.getTimestamp(), kafkaMessage.getMessage()));
		throw new RuntimeException("test");
	}

	@DltHandler
	public void dlt(@Payload KafkaMessage kafkaMessage, @Header(KafkaHeaders.RECEIVED_TOPIC) String topic) {
		System.out.println(String.format("Message received in DLT %s  %s - %s", topic, kafkaMessage.getTimestamp(),
				kafkaMessage.getMessage()));
	}

}
