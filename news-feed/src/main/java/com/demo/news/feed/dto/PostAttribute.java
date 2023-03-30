package com.demo.news.feed.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.Column;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PostAttribute {

    @JsonProperty("user_id")
    private Integer userId;
    private String content;
    private String contentType;
    private Double latitude;
    private Double longitude;
}
