package com.demo.news.feed.model.request;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class PostDetails {

    private Integer userId;
    private String content;
    private String content_type;
    private Double postLatitude;
    private Double postLongitude;
    private int numFavourites;
}
