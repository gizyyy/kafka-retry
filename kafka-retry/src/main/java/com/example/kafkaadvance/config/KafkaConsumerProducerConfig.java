package com.example.kafkaadvance.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.ConcurrentKafkaListenerContainerFactory;
import org.springframework.kafka.core.ConsumerFactory;
import org.springframework.kafka.core.KafkaTemplate;

import lombok.AllArgsConstructor;

@Configuration
@AllArgsConstructor
public class KafkaConsumerProducerConfig {

	private final KafkaTemplate<String, KafkaMessage> replyTemplate;
	private final ConsumerFactory<String, KafkaMessage> consumerFactory;

	@Bean
	public ConcurrentKafkaListenerContainerFactory<String, KafkaMessage> kafkaListenerContainerFactory() {
		ConcurrentKafkaListenerContainerFactory<String, KafkaMessage> factory = new ConcurrentKafkaListenerContainerFactory<>();
		factory.setConsumerFactory(consumerFactory);
		factory.setReplyTemplate(replyTemplate);
		return factory;
	}

}
