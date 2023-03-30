package com.demo.news.feed.repositories;

import com.demo.news.feed.entity.UserFollower;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IUserFollowerRepository extends JpaRepository<UserFollower, Long> {

    @Query(value = "select follower_id from user_follower where user_id =?", nativeQuery = true)
    List<Integer> findByUserId(Integer userId);



}
