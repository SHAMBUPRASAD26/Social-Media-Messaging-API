package com.example.social_media_api.repository;

import com.example.social_media_api.entity.Message;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MessageRepository extends JpaRepository<Message, Integer> {
    List<Message> findByPostedBy(Integer account_id);
}
