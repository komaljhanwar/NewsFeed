package com.demo.news.feed.service.impl;

//import com.demo.news.feed.entity.FeedItem;
import com.demo.news.feed.entity.FeedItem;
import com.demo.news.feed.entity.FeedMedia;
import com.demo.news.feed.entity.Media;
import com.demo.news.feed.model.request.PostDetails;
//import com.demo.news.feed.repositories.IFeedItemRepository;
import com.demo.news.feed.model.response.IResponse;
import com.demo.news.feed.model.response.SuccessFailureResponse;
import com.demo.news.feed.repositories.IFeedItemRepository;
import com.demo.news.feed.repositories.IFeedMediaRepository;
import com.demo.news.feed.service.interfaces.IUserService;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;


@Log4j2
@Service
public class UserService implements IUserService {

   @Autowired
   IFeedItemRepository feedItemRepository;

   @Autowired
   IFeedMediaRepository feedMediaRepository;

    @Override
    public SuccessFailureResponse createPost(PostDetails post) {
        try {
       FeedItem feedItem = FeedItem.builder().userId(post.getUserId()).content(post.getContent())
                        .contentType(post.getContent_type()).latitude(post.getPostLatitude()).feedItemId(1)
                        .longitude(post.getPostLongitude()).numFavourites(post.getNumFavourites()).build();
       FeedItem itemResult = feedItemRepository.save(feedItem);

       /*FeedMedia feedMedia = FeedMedia.builder().feedItemId(itemResult.getFeedItemId()).build();
       FeedMedia feedMediaResult = feedMediaRepository.save(feedMedia);

       Media media = Media.builder().type()build();*/
        }catch (DataAccessException ex) {
           log.error("Failed to save post", ex);
       }
       SuccessFailureResponse success = new SuccessFailureResponse();
       success.setMessage("Post is created successfully");
       success.setStatus(true);
       success.setHttpCode(HttpStatus.OK);
       return  success;
    }
}
