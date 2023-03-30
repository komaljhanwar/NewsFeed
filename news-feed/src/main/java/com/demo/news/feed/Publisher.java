package com.demo.news.feed;

import com.demo.news.feed.listener.EventListener;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component

public class Publisher {

    /*private final ApplicationEventPublisher Publisher;

    Publisher(ApplicationEventPublisher publisher) {
        this.Publisher = publisher;
    }

    public void publishEvent(GenericEvent event) {
        Publisher.publishEvent(event);
    }*/
   private List<EventListener> subscribers = new ArrayList<>();

    public void subscribe(List<EventListener> subscriber) {
        this.subscribers = subscriber;
    }

    public void unsubscribe(EventListener subscriber) {
        subscribers.remove(subscriber);
    }

    public void publishEvent(Event event) {
        for (EventListener subscriber : subscribers) {
            subscriber.onEvent(event);
        }
    }
}