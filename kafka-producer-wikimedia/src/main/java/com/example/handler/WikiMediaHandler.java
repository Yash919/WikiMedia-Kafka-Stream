package com.example.handler;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.core.KafkaTemplate;

import com.launchdarkly.eventsource.EventHandler;
import com.launchdarkly.eventsource.MessageEvent;

public class WikiMediaHandler implements EventHandler {

	private static final Logger LOGGER = LoggerFactory.getLogger(WikiMediaHandler.class);
	private String topic;
	private KafkaTemplate<String, String> kafkaTemplate;

	public WikiMediaHandler(String topic, KafkaTemplate<String, String> kafkaTemplate) {
		this.topic = topic;
		this.kafkaTemplate = kafkaTemplate;
	}

	@Override
	public void onOpen() throws Exception {

	}

	@Override
	public void onClosed() throws Exception {

	}

	@Override
	public void onMessage(String s, MessageEvent messageEvent) throws Exception {

		LOGGER.info(String.format("event Data -> %s",messageEvent.getData()));

		kafkaTemplate.send(topic,messageEvent.getData());

	}

	@Override
	public void onComment(String s) throws Exception {

	}

	@Override
	public void onError(Throwable throwable) {

	}
}