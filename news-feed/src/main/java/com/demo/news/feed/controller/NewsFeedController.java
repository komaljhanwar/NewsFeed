package com.demo.news.feed.controller;

import com.demo.news.feed.Consumer;
import com.demo.news.feed.model.request.PostDetails;
import com.demo.news.feed.model.response.SuccessFailureResponse;
import com.demo.news.feed.service.interfaces.INewsFeedService;
import com.demo.news.feed.service.interfaces.INotificationPublisherService;
import com.demo.news.feed.service.interfaces.ITimelineService;
import com.demo.news.feed.service.interfaces.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping
public class NewsFeedController {

    @Autowired
    IUserService userService;

    @Autowired
    INewsFeedService newsFeedService;

    @Autowired
    INotificationPublisherService notificationPublisherService;

    @Autowired
    ITimelineService timelineService;

    Map<String, List<Consumer>> subscriber;

    @PostMapping(value = "/createPost")
    public ResponseEntity createPost(@RequestBody PostDetails body) {
        SuccessFailureResponse response = userService.createPost(body);
        return new ResponseEntity(response, response.getHttpCode());
    }

    @PostMapping(value = "/subscribe/{topic}")
    public ResponseEntity subscribeToTopic(@PathVariable String topic) {
        notificationPublisherService.publish(topic);

        return new ResponseEntity(HttpStatus.OK);
    }

    @PostMapping(value = "/event/notification/{topic}")
    public ResponseEntity publish(@PathVariable String topic) {
        notificationPublisherService.publish(topic);

        return new ResponseEntity(HttpStatus.OK);
    }

    @GetMapping(value="/newsfeed/{id}")
    public ResponseEntity getNewsFeed(@PathVariable String id) {
        SuccessFailureResponse response = newsFeedService.getNewsFeed(id);

        return new ResponseEntity(response.getMessage(), response.getHttpCode());
    }

    @GetMapping(value="/newsfeed/{latitude}/{longitude}/{id}")
    public ResponseEntity getNewsFeedAroundLocation(@PathVariable String id, @PathVariable Double latitude,
                                                    @PathVariable Double longitude) {
        newsFeedService.getNewsFeedByLocation(latitude, longitude, id);

        return new ResponseEntity(HttpStatus.ACCEPTED);
    }


}
