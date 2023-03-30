package com.demo.news.feed.service.interfaces;

import com.demo.news.feed.model.response.SuccessFailureResponse;

import java.util.UUID;

public interface INewsFeedService {

    SuccessFailureResponse getNewsFeed(String userId);

    void getNewsFeedByLocation(Double latitude, Double longitude, String userId);

}
