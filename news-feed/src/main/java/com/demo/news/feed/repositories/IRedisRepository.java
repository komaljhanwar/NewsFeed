package com.demo.news.feed.repositories;

import com.demo.news.feed.entity.Notification;
import org.springframework.data.repository.CrudRepository;

public interface IRedisRepository extends CrudRepository<Notification, String> {
}
