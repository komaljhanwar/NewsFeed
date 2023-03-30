package com.demo.news.feed;

import lombok.Getter;
import lombok.Setter;

@Getter
public class Event {
    private String data;

    public Event(String data) {
        this.data = data;
    }
}
