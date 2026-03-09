package com.urlshortener.backend.model;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;


@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "urls")
public class Url {
    @Id
    private String id;

    private String shortCode;

    private String originalUrl;

    private Long createdAt;

    private Long clicks;
}