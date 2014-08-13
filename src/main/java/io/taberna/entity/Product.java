package io.taberna.entity;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Created by nicolas.ritouet on 12/08/14.
 */
public class Product {

    private long id;

    private String name;

    private String reference;

    private String description;

    public Product() {

    }

    public Product(long id, String name, String reference, String description) {
        this.id = id;
        this.name = name;
        this.reference = reference;
        this.description = description;
    }

    @JsonProperty
    public long getId() {
        return id;
    }

    @JsonProperty
    public String getName() {
        return name;
    }

    @JsonProperty
    public String getReference() {
        return reference;
    }

    @JsonProperty
    public String getDescription() {
        return description;
    }
}
