package com.demo.news.feed.service.impl;

//import com.demo.news.feed.entity.FeedItem;
import com.demo.news.feed.entity.Post;
import com.demo.news.feed.model.request.PostDetails;
//import com.demo.news.feed.repositories.IFeedItemRepository;
import com.demo.news.feed.model.response.SuccessFailureResponse;
import com.demo.news.feed.repositories.IFeedItemRepository;
import com.demo.news.feed.repositories.IFeedMediaRepository;
import com.demo.news.feed.service.interfaces.IUserService;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;


@Log4j2
@Service
public class UserService implements IUserService {

   @Autowired
   IFeedItemRepository feedItemRepository;

   @Autowired
   IFeedMediaRepository feedMediaRepository;

   @Autowired
    StringRedisTemplate redisTemplate;

    @Override
    public SuccessFailureResponse createPost(PostDetails post) {
        SuccessFailureResponse success = null;;
        try {
       Post feedItem = Post.builder().userId(post.getUserId()).content(post.getContent())
                        .contentType(post.getContent_type()).latitude(post.getPostLatitude()).feedItemId(1)
                        .longitude(post.getPostLongitude()).numFavourites(post.getNumFavourites()).build();

       feedItemRepository.save(feedItem);
            success = new SuccessFailureResponse();
            success.setMessage("Post is created successfully");
            success.setStatus(true);
            success.setHttpCode(HttpStatus.OK);

        }catch(Exception ex) {
            if(ex instanceof  DataAccessException) {
                log.error("Failed to save post", ex);
            }
    }
        return  success;
    }
}
