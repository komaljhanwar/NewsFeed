package com.demo.news.feed.repositories;

import com.demo.news.feed.dto.PostAttribute;
import com.demo.news.feed.entity.FeedItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.List;
import java.util.UUID;

@Repository
public interface IFeedItemRepository extends JpaRepository<FeedItem, UUID> {


    /*@Query("select item.* from user_follower u left join feed_item item on u.user_id = item.user_id where u.follower_id =? " +
            " order by item.creation_date desc LIMIT 50")
    List<FeedItem> findByFollowerId(Integer followerId);*/


   /* @Query("select item from user_follower u join on feed_item item where u.follower_id =? and " +
            "item.creator_id = u.user_id and item.latitude=? and item.longitude =? order by item.creation_date, numFavourite  desc LIMIT 10")
    */
   /*@Query("select * from feed_item item where item.creator_id = userId and item.latitude=? and item.longitude =?")
    List<FeedItem> findFeedItemByLocation(String userId, Double Latitude, Double Longitude);
*/

   // @Query(value = "Select user_id, content, content_type, latitude, longitude from feed_item where user_id IN :userId ", nativeQuery = true)
    List<FeedItem> findByUserIdIn(Collection<Integer> userId);
}