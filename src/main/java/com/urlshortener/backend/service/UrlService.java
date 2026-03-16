package com.urlshortener.backend.service;

import com.urlshortener.backend.model.Url;
import com.urlshortener.backend.repository.UrlRepository;
import com.urlshortener.backend.util.Base52Encoder;
import com.urlshortener.backend.util.SequenceGeneratorService;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.stereotype.Service;

@Service
public class UrlService {

    private final UrlRepository urlRepository;
    private final SequenceGeneratorService sequenceGeneratorService;

    public UrlService(UrlRepository urlRepository, SequenceGeneratorService sequenceGeneratorService) {
        this.urlRepository = urlRepository;
        this.sequenceGeneratorService = sequenceGeneratorService;
    }

    public String shortenUrl(String originalUrl) {
        String code = null;
        boolean saved = false;

        while (!saved) {
            // Get unique numeric ID from sequence
            long numericId = sequenceGeneratorService.getNextSequence("url_sequence");

            // Encode numeric ID to letters-only short code
            code = Base52Encoder.encode(numericId);

            Url url = Url.builder()
                    .originalUrl(originalUrl)
                    .shortCode(code)
                    .createdAt(System.currentTimeMillis())
                    .clicks(0L)
                    .build();

            try {
                urlRepository.save(url); // Attempt to save
                saved = true;            // Success
            } catch (DuplicateKeyException e) {
                // Collision detected, retry with next sequence
                System.out.println("Collision detected for code " + code + ", retrying...");
            }
        }

        System.out.println("Shortened URL: " + originalUrl + " -> " + code);
        return code;
    }

    public String resolve(String code) {
        Url url = urlRepository.findByShortCode(code)
                .orElseThrow(() -> new RuntimeException("URL not found"));

        url.setClicks(url.getClicks() + 1);
        urlRepository.save(url);

        return url.getOriginalUrl();
    }
}