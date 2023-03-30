package com.demo.news.feed.service.impl;

import com.demo.news.feed.Event;
import com.demo.news.feed.GenericEvent;
import com.demo.news.feed.Publisher;
import com.demo.news.feed.TopicSubscriber;
import com.demo.news.feed.listener.EventListener;
import com.demo.news.feed.service.interfaces.INotificationPublisherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class NotificationPublisherService implements INotificationPublisherService {

    @Autowired
    Publisher publisher;

    @Override
    public void publish(String topic) {

//        GenericEvent event1 = new GenericEvent<>(this, topic );
//        GenericEvent event2 = new GenericEvent<>(this, "Hello");
//        publisher
//                .publishEvent(
//                        (event1));

        // Create two subscribers
        Publisher publisher = new Publisher();

        Map<String, List<EventListener>> map = TopicSubscriber.getSubscriberList();
        publisher.subscribe(map.get(topic));

        // Publish an event
        Event event = new Event("New alert");
        publisher.publishEvent(event);
    }
}

