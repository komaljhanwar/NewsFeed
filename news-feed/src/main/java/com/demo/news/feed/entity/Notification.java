package com.demo.news.feed.entity;

import com.demo.news.feed.enums.TopicName;
import org.springframework.data.redis.core.RedisHash;

import java.io.Serializable;
import java.util.List;

@RedisHash("Notification")
public class Notification implements Serializable {
    private String id;
    private TopicName topicName;
    private List<Integer> userId;
}
