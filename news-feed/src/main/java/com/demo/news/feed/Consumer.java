package com.demo.news.feed;

import com.demo.news.feed.listener.EventListener;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

//@Component
public class Consumer implements EventListener {

    /*@Async
    @EventListener
    void sendMsgEvent(Event event) {
        System.out.println("==EmailListener 1 ==="+event.getData() );
    }*/

    private String name;

    public Consumer(String name) {
        this.name = name;
    }
    @Override
    public void onEvent(Event event) {
        System.out.println(name + " received event: " + event.getData());
    }
}
