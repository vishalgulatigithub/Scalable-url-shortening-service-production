package com.urlshortener.backend.graphql;

import com.urlshortener.backend.service.UrlService;
import org.springframework.graphql.data.method.annotation.*;
import org.springframework.stereotype.Controller;

@Controller
public class UrlGraphQLController {

    private final UrlService urlService;

    public UrlGraphQLController(UrlService urlService) {
        this.urlService = urlService;
    }

    @MutationMapping
    public String shorten(@Argument String url) {
        return urlService.shortenUrl(url);
    }

    @QueryMapping
    public String resolve(@Argument String code) {
        return urlService.resolve(code);
    }
}