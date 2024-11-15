package com.example.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import com.example.entity.WikiMedia;
import com.example.repository.WikiMediaRepository;

@Service
public class WikiMediaConsumer {

	private static final Logger LOGGER = LoggerFactory.getLogger(WikiMediaConsumer.class);

	private WikiMediaRepository wikiMediaRepository;

	public WikiMediaConsumer(WikiMediaRepository wikiMediaRepository) {
		this.wikiMediaRepository = wikiMediaRepository;
	}

	@KafkaListener( topics = "${spring.kafka.topic.name}", groupId = "${spring.kafka.consumer.group-id}")
	public void consume(String eventMessage){
		LOGGER.info(String.format("Event Message Received -> %s",eventMessage));

		WikiMedia wikiMedia = new WikiMedia();
		wikiMedia.setWikiEventData(eventMessage);
		wikiMediaRepository.save(wikiMedia);
	}
}