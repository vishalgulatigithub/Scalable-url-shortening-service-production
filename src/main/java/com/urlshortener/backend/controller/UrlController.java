package com.urlshortener.backend.controller;

import com.urlshortener.backend.dto.UrlRequest;
import com.urlshortener.backend.service.UrlService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;


@RestController
@CrossOrigin(origins = {"https://shortenup.netlify.app", "http://localhost:5173", "http://localhost:5174"})
@RequestMapping("/api/url")
public class UrlController {

    private final UrlService urlService;

    public UrlController(UrlService urlService) {
        this.urlService = urlService;
    }
    // (fixes 404)
    @GetMapping("/")
    public String home() {
        return "URL Shortener is running 🚀";
    }

    @PostMapping("/shorten")
    public String shorten (@RequestBody UrlRequest request) {
        return urlService.shortenUrl(request.getOriginalUrl());
    }

    @GetMapping("/{code}")
    public ResponseEntity<Void> redirect(@PathVariable String code) {

        String originalUrl = urlService.resolve(code);

        return ResponseEntity
                .status(HttpStatus.FOUND)
                .location(URI.create(originalUrl))
                .build();
    }

}
