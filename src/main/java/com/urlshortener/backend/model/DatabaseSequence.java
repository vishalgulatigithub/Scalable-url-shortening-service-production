package com.urlshortener.backend.model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document(collection = "database_sequences")
public class DatabaseSequence {

    @Id
    private String id; // name of the sequence, e.g., "url_sequence"

    private long seq;  // current numeric value
}