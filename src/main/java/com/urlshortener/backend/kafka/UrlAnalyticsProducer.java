package com.urlshortener.backend.kafka;

import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class UrlAnalyticsProducer {

    private final KafkaTemplate<String, String> kafkaTemplate;

    public UrlAnalyticsProducer(KafkaTemplate<String, String> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    public void publishClick(String shortCode) {
        kafkaTemplate.send("url-clicks", shortCode);
    }
}