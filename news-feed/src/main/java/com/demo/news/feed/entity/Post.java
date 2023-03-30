package com.demo.news.feed.entity;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Builder
@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class Post {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Long id;
    @Column(name = "user_id")
    private Integer userId;
    @Column(name = "post_id")
    private int feedItemId;
    @Column(name = "content")
    private String content;
    @Column(name = "content_type")
    private String contentType;
    @Column(name = "latitude")
    private Double latitude;
    @Column(name = "longitude")
    private Double longitude;
    private LocalDateTime creationDate;
    @Column(name = "num_favourites")
    private Integer numFavourites;
}
