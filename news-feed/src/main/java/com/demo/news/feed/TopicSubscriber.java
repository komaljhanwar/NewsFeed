package com.demo.news.feed;

import com.demo.news.feed.enums.TopicName;
import com.demo.news.feed.listener.EventListener;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TopicSubscriber {

    private static Map<String, List<EventListener>> map = new HashMap<>();

    public static Map<String, List<EventListener>> getSubscriberList() {

        if(map.isEmpty()) {
            ArrayList list = new ArrayList();
            list.add(new Consumer("User1"));
            list.add(new Consumer("User2"));
            map.put(TopicName.CAR.getTopic(), new ArrayList<>(list));

            list = new ArrayList<>();
            list.add(new Consumer("User3"));
            map.put(TopicName.MOVIE.getTopic(), new ArrayList<>(list));

            list = new ArrayList<>();
            list.add(new Consumer("User1"));
            map.put(TopicName.GAME.getTopic(), new ArrayList<>(list));
            return map;
        }

        return map;
    }
}
