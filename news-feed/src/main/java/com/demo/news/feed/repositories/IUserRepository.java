package com.demo.news.feed.repositories;

import com.demo.news.feed.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface IUserRepository extends JpaRepository<User, UUID> {
}
