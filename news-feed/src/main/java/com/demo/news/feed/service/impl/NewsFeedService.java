package com.demo.news.feed.service.impl;


import com.demo.news.feed.dto.PostAttribute;
import com.demo.news.feed.entity.FeedItem;
import com.demo.news.feed.model.response.SuccessFailureResponse;
import com.demo.news.feed.repositories.IFeedItemRepository;
import com.demo.news.feed.repositories.IUserFollowerRepository;
import com.demo.news.feed.service.interfaces.INewsFeedService;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Log4j2
@Service
public class NewsFeedService implements INewsFeedService {

    @Autowired
    IFeedItemRepository feedItemRepository;

    @Autowired
    IUserFollowerRepository userFollowerRepository;


    @Override
    public SuccessFailureResponse getNewsFeed(String userId) {
        List<FeedItem> list = new ArrayList<>();
        try {
            List<Integer> followerIdList = userFollowerRepository.findByUserId(Integer.valueOf(userId));
            log.info(" folllower list" + followerIdList );
            list = feedItemRepository.findByUserIdIn(followerIdList);
            log.info("  list" + list );


        } catch (DataAccessException ex) {
            log.error("Failed while reading from db", ex);
        }
        SuccessFailureResponse response = new SuccessFailureResponse();
        response.setHttpCode(HttpStatus.OK);
        response.setMessage(list);
        response.setStatus(true);
        return  response;
    }

    @Override
    public void getNewsFeedByLocation(Double latitute, Double longitute, String userId) {
       // feedItemRepository.findFeedItemByLocation(userId, latitute, longitute);
    }
}
