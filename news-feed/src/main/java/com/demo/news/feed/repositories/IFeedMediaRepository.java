package com.demo.news.feed.repositories;

import com.demo.news.feed.entity.FeedMedia;
import org.springframework.data.jpa.repository.JpaRepository;


public interface IFeedMediaRepository extends JpaRepository<FeedMedia, Integer> {
}
