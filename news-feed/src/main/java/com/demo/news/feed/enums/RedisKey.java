package com.demo.news.feed.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum RedisKey {
    REGISTERED_USER("R-"),
    JOINED_USER("J-"),

    EVENT_INFO("E-");

    private final String key;
}
