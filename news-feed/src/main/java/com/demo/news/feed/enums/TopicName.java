package com.demo.news.feed.enums;

import lombok.Getter;

@Getter
public enum TopicName {
    CAR("car"),
    MOVIE("movie"),
    ELECTION("election"),
    GAME("game"),
    COMEDY("comedy");

    private String topic;
     TopicName(String topic) {
        this.topic = topic;
    }
}
