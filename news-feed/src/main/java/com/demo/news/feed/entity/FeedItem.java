package com.demo.news.feed.entity;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

import static jakarta.persistence.CascadeType.ALL;

@Builder
@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class FeedItem {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Long id;
    @Column(name = "user_id")
    private Integer userId;
    @Column(name = "feed_item_id")
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

    /*@ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", insertable = false, updatable = false)
    @Fetch(FetchMode.JOIN)
    private User user;*/
}
