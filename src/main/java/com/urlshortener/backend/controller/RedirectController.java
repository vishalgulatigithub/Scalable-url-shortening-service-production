package com.urlshortener.backend.controller;

import com.urlshortener.backend.model.Url;
import com.urlshortener.backend.repository.UrlRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.Optional;

@RestController
public class RedirectController {

    @Autowired
    private UrlRepository urlRepository;

    @GetMapping("/{shortCode}")
    public ResponseEntity<?> redirect(@PathVariable String shortCode) {

        Optional<Url> urlOptional = urlRepository.findByShortCode(shortCode);

        if (urlOptional.isPresent()) {
            Url url = urlOptional.get();
            return ResponseEntity
                    .status(302)
                    .location(URI.create(url.getOriginalUrl()))
                    .build();
        }

        return ResponseEntity.notFound().build();
    }
}