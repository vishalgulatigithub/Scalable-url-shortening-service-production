package com.urlshortener.backend.service;

import com.urlshortener.backend.model.Url;
import com.urlshortener.backend.repository.UrlRepository;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class UrlService {

    private final UrlRepository urlRepository;

    public UrlService(UrlRepository urlRepository) {
        this.urlRepository = urlRepository;
    }

    public String shortenUrl(String originalUrl) {

        String code = UUID.randomUUID().toString().substring(0,8);

        Url url = Url.builder()
                .shortCode(code)
                .originalUrl(originalUrl)
                .createdAt(System.currentTimeMillis())
                .clicks(0L)
                .build();

        urlRepository.save(url);
        System.out.println("Saving URL: " + originalUrl);

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