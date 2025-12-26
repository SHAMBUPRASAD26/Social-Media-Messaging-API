package com.example.social_media_api.service;

import com.example.social_media_api.entity.Message;
import com.example.social_media_api.repository.MessageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MessageService {

    @Autowired
    private MessageRepository repo;

    @Autowired
    private AccountService accountService;

    public Message create(Message message) {
        if (message.getMessage_text().isBlank() || message.getMessage_text().length() > 255)
            return null;

        if (!accountService.exists(message.getPostedBy()))
            return null;

        message.setTime_posted_epoch(System.currentTimeMillis());
        return repo.save(message);
    }

    public List<Message> getAll() {
        return repo.findAll();
    }

    public Message getById(Integer id) {
        return repo.findById(id).orElse(null);
    }

    public int delete(Integer id) {
        if (!repo.existsById(id)) return 0;
        repo.deleteById(id);
        return 1;
    }

    public int update(Integer id, String text) {
        if (text.isBlank() || text.length() > 255) return 0;

        Message msg = repo.findById(id).orElse(null);
        if (msg == null) return 0;

        msg.setMessage_text(text);
        repo.save(msg);
        return 1;
    }

    public List<Message> getByUser(Integer id) {
        return repo.findByPostedBy(id);
    }
}
